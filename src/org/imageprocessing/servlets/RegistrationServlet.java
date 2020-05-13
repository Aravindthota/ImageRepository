package org.imageprocessing.servlets;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.imageprocessing.beans.PatientDetails;
import org.imageprocessing.conversions.ConvertToBase64;
import org.imageprocessing.utils.DBUtils;
import org.imageprocessing.utils.MyUtils;

@WebServlet(urlPatterns = { "/register" })
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Forward to /WEB-INF/views/registrationview.jsp
		// (Users can not access directly into JSP pages placed in WEB-INF)
		RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/WEB-INF/views/registrationview.jsp");

		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PatientDetails patient = new PatientDetails();
		String base64ImageString = "";
		// Check that we have a file upload request
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();

			ServletContext servletContext = this.getServletConfig().getServletContext();
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);
			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> formItems;

			try {
				formItems = upload.parseRequest(new ServletRequestContext(request));
				if (formItems != null && formItems.size() > 0) {
					for (FileItem item : formItems) {
						if (!item.isFormField()) {
							// Encoding password and Image to Base64 String for storing into DB
							base64ImageString = ConvertToBase64.encoder(item);
							patient.setBase64Image(base64ImageString);
						}
						if (item.isFormField()) {
							String fieldname = item.getFieldName();
							if (fieldname.equalsIgnoreCase("firstName")) {
								patient.setFirstName(item.getString());
							}
							if (fieldname.equalsIgnoreCase("lastName")) {
								patient.setLastName(item.getString());
							}
							if (fieldname.equalsIgnoreCase("password")) {
								String base64PasswordString = ConvertToBase64.encodePassword(item.getString());
								patient.setPassword(base64PasswordString);
							}
							if (fieldname.equalsIgnoreCase("email")) {
								patient.setEmail(item.getString());
							}
							if (fieldname.equalsIgnoreCase("phone")) {
								patient.setMobile(item.getString());
							}
							if (fieldname.equalsIgnoreCase("dob")) {
								patient.setDob(item.getString());
							}
							if (fieldname.equalsIgnoreCase("address")) {
								patient.setAddress(item.getString());
							}
							if (fieldname.equalsIgnoreCase("gender")) {
								patient.setGender(item.getString());
							}
						}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		boolean hasError = false;
		String errorString = null;
		boolean userRegistered = false;
		String responseString = null;

		Connection conn = MyUtils.getStoredConnection(request);
		try {
			// Find the user in the DB.
			userRegistered = DBUtils.validatePatient(conn, patient.getEmail(), patient.getMobile());
			if (userRegistered) {
				hasError = true;
				errorString = "User already registered, Please login";
			}
			if (hasError) {
				patient = new PatientDetails();

				// Store information in request attribute, before forward.
				request.setAttribute("errorString", errorString);

				// Forward to /WEB-INF/views/login.jsp
				RequestDispatcher dispatcher //
						= this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginview.jsp");

				dispatcher.forward(request, response);
			}
			// If no error
			// register user by adding details to DB
			else {

				DBUtils.insertPatientDetails(conn, patient);
				responseString = "Registered Successfully,Please login in";
				// Store information in request attribute, before forward.
				request.setAttribute("successString", responseString);
				// Forward to /WEB-INF/views/login.jsp
				RequestDispatcher dispatcher //
						= this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginview.jsp");

				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			hasError = true;
			errorString = e.getMessage();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package servletControllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dbAdapter.DBProduct;

@WebServlet("/imageDownload")
public class ProductImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductImageController() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		byte[] image = DBProduct.getProductImage(id);

		response.getOutputStream().write(image);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
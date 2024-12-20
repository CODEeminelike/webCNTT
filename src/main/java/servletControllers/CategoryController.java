package servletControllers;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dataModel.Category;
import dbAdapter.DBCategory;

@WebServlet("/category/*")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CategoryController() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Get the requested url from the Request object.
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
		String url = "/categories";

		if (requestURI.endsWith("/getProductsByCategory")) {
			url = getProductsByCategory(request, response);
		}

		getServletContext().getRequestDispatcher(url)
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	// Retrieve all products belonging to a particular category.
	private String getProductsByCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		List<Category> categories = DBCategory.getCategories();
		HttpSession session = request.getSession();

		int id = Integer.parseInt(request.getParameter("id"));

		Category category = null;
		for (Category c : categories) {
			category = c;
			if (category.getId() == id)
				break;
		}

		session.setAttribute("selectedCategory", category);
		return "/categories/displayProductsByCategory.jsp";
	}

}

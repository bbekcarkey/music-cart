package com.emusicstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.emusicstore.dao.CartDao;
import com.emusicstore.daointer.ProductDaoInter;
import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import com.emusicstore.model.Product;



@RequestMapping("/rest/cart")
@Controller
public class CartController {

	@Autowired
        private CartDao cartDao;

        
        @Autowired
    	private ProductDaoInter productdao;
        
        

		@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
        public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId) {

                return cartDao.read(cartId);
        }

        @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
        @ResponseStatus(value = HttpStatus.NO_CONTENT)
        public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart) {

                cartDao.update("cartId", cart);
        }

        @RequestMapping(value = "/{cartId})", method = RequestMethod.DELETE)
        @ResponseStatus(value = HttpStatus.NO_CONTENT)
        public void delete(@PathVariable(value = "cartId") String cartId) {
                cartDao.delete(cartId);
        }

        @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
        public void addItem(@PathVariable(value = "productId") String productId, HttpServletRequest request) {
        	 System.out.println("haha");

      
                String sessionId = request.getSession(true).getId();

                Cart cart = cartDao.read(sessionId);

                if (cart == null) {
                        cart = cartDao.create(new Cart(sessionId));
                }

                Product product = productdao.getProductbyId(productId);
                if (product == null) {
                	System.out.println("error");
                        throw new IllegalArgumentException(new Exception());
                }

                cart.addCartItem(new CartItem(product));

               // cartDao.update(("sessionId"), cart);
        }

        @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
        @ResponseBody
        public boolean removeItem(@PathVariable(value = "productId")  String productId, HttpServletRequest request) {
        	System.out.println("delete");
                String sessionId = request.getSession(true).getId();
            	System.out.println("delete1");
                Cart cart = cartDao.read(sessionId);
            
             System.out.println("cart>> "+cart);
             for(Product p: productdao.getAllProduct()){
            	 System.out.println("<> "+p);
             }
                Product product = productdao.getProductbyId(productId);
                
                System.out.println("prod>>> "+product);
                System.out.println(product.getProductName());
                System.out.println("deleted");
                
                cart.removeCartItem(new CartItem(product));
             
                System.out.println("half");
                
                cartDao.update(sessionId, cart);
                System.out.println("all don");
                return true;
        }

        @ExceptionHandler(IllegalArgumentException.class)
        @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
        public void handleClientErrors(Exception e) {
        }

        @ExceptionHandler(Exception.class)
        @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server")
        public void handleServerErrors(Exception e) {
        }

}
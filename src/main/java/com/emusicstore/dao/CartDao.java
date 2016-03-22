package com.emusicstore.dao;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.emusicstore.daointer.CartDaoInter;
import com.emusicstore.model.Cart;

@Repository
public class CartDao implements CartDaoInter
{
	
	        private Map<String, Cart> listOfCarts;

	        public CartDao() {
	                listOfCarts = new HashMap<String, Cart>();
	        }

	        
	        @Override
	        public Cart create(Cart cart) {
	                if (listOfCarts.keySet().contains(cart.getCartId())) {
	                        throw new IllegalArgumentException(String.format(
	                                        "Can not create a cart. A cart with the given id(%) " + "already " + "exists", cart.getCartId()));
	                }

	                listOfCarts.put(cart.getCartId(), cart);

	                return cart;
	        }

	        @Override
	        public Cart read(String cartId) {
	        	
	                return listOfCarts.get(cartId);
	        }

	        @Override
	        public void update(String cartId, Cart cart) {
	                if (!listOfCarts.keySet().contains(cartId)) {
	                        throw new IllegalArgumentException(String.format(
	                                        "Can not update cart. The cart with the given id(%) " + "does not " + "exist", cart.getCartId()));
	                }

	                listOfCarts.put(cartId,cart);
	        }

			@Override
			public void delete(String cartId) {
				if (!listOfCarts.keySet().contains(cartId)) {
                    throw new IllegalArgumentException(
                                    String.format("Can not delete cart. A cart with the given id(%) " + "does not " + "exist", cartId));
            }

            listOfCarts.remove(cartId);
				
			}
	}


package com.emusicstore.daointer;

import com.emusicstore.model.Cart;

public interface CartDaoInter {
        Cart create (Cart cart);

        Cart read(String cartId);

        void update(String cartId,Cart cart);
        void delete(String cartId);
}

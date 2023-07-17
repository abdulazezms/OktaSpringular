package com.aziz.ecommerce.controller;

import com.aziz.ecommerce.dto.PurchaseRequestDto;
import com.aziz.ecommerce.dto.PurchaseResponseDto;
import com.aziz.ecommerce.service.CheckoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {
    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponseDto> purchase(@RequestBody PurchaseRequestDto purchaseRequestDto){
        System.out.println(purchaseRequestDto.getCustomer());
        System.out.println(purchaseRequestDto.getOrder());
        System.out.println(purchaseRequestDto.getBillingAddress());
        System.out.println(purchaseRequestDto.getShippingAddress());
        return new ResponseEntity<>(this.checkoutService.placeOrder(purchaseRequestDto), HttpStatus.CREATED);
    }
}

package com.nisum.Purchase.service;

import com.nisum.Purchase.model.Purchase;
import com.nisum.Purchase.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    private PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public List<Purchase> getAllPurchases(){
        return purchaseRepository.findAll();
    }

   public Optional<Purchase> findByCustomerId(Long customerId){return purchaseRepository.findById(customerId);}

    public Purchase getPurchaseById(Long id){
        return purchaseRepository.findById(id).orElse(null);
    }

    public Purchase createPurchase(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

    public Purchase updatePurchase(Long id , Purchase purchase){
        if(purchaseRepository.existsById(id)){
            purchase.setPurchaseid(id);
            return purchaseRepository.save(purchase);
        }
        return null;
    }

    public void deletePurchaseById(Long id) {
        if (purchaseRepository.existsById(id)) {
            purchaseRepository.deleteById(id);
        } else {
            System.out.println("Customer with " + id + "Does Not Exits");
        }
    }
}

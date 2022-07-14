package lk.rent.app.service;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.PayementsDTO;


import java.util.List;

public interface PayementsService {
    void addPayements(PayementsDTO payementsDTO);
    void updatePayements(PayementsDTO payementsDTO);
    List<PayementsDTO> getPayements();
    void deletePayements(String id);
    PayementsDTO findPayements(String id);
}

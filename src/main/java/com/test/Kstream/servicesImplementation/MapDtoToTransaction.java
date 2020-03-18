package com.test.Kstream.servicesImplementation;

import com.test.Kstream.dataTransferObject.BankingInfosDto;
import com.test.Kstream.dataTransferObject.TransactionDataDto;
import com.test.Kstream.entities.BankTransactionEntity;
import com.test.Kstream.services.MapDtoToEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("MapDtoToTransaction")
public class MapDtoToTransaction implements MapDtoToEntity<BankTransactionEntity,BankingInfosDto> {


    private final ModelMapper modelMapper;

    public MapDtoToTransaction(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public BankTransactionEntity MapToEntity(BankingInfosDto Dto, Class<BankTransactionEntity> Entity) {

        return modelMapper.map(Dto.getTransactionData(), Entity);
    }

    @Override
    public void SetEntityFields(BankingInfosDto Dto, BankTransactionEntity Entity) {
        Entity.setFullName(Dto.getFullName());
        Entity.setJoinDate(Dto.getJoinDate());
        Entity.setTransactionBankCardNumber(Dto.getTransactionBankCardEntity().getCardNumber());
        Entity.setTransactionBankAccountNumber(Dto.getTransactionBankAccountEntity().getAccountNumber());

    }
}

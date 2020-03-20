package com.test.Kstream.servicesImplementation;

import com.test.Kstream.configurations.ModelMapperConfig;
import com.test.Kstream.dataTransferObject.BankingInfosDto;
import com.test.Kstream.dataTransferObject.TransactionDataDto;
import com.test.Kstream.entities.BankTransactionEntity;
import com.test.Kstream.enums.*;
import com.test.Kstream.services.MapDtoToEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("MapDtoToTransaction")
public class MapDtoToTransaction implements MapDtoToEntity<BankTransactionEntity, BankingInfosDto, TransactionDataDto> {
    private final ModelMapper modelMapper;


    public MapDtoToTransaction(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public BankTransactionEntity MapToEntity(TransactionDataDto Dto, Class<BankTransactionEntity> Entity) {
        return modelMapper.map(Dto, Entity);
    }

    @Override
    public void SetEntityFields(BankingInfosDto Dto, BankTransactionEntity Entity) throws Exception {
        Entity.setTransactionActivity(Activity.fromString(Dto.getTransactionData().getTransactionActivity()));
        Entity.setTransactionAmount(AmountOfTransaction.fromString(Dto.getTransactionData().getTransactionAmount()));
        Entity.setAuthenticationMethod(AuthenticationMethod.fromString(Dto.getTransactionData().getAuthenticationMethod()));
        Entity.setAuthorized(Authorization.fromString(Dto.getTransactionData().getAuthorized()));
        Entity.setClientPresence(ClientPresence.fromString(Dto.getTransactionData().getClientPresence()));
        Entity.setCountryOfTheCommerce(CountryOfTheCommerce.fromString(Dto.getTransactionData().getCountryOfTheCommerce()));
        Entity.setProcessCode(ProcessCode.fromString(Dto.getTransactionData().getProcessCode()));
        Entity.setResponseCode(ResponseCode.fromString(Dto.getTransactionData().getResponseCode()));
        Entity.setTerminalCaptureCapacity(TerminalCaptureCapacity.fromString(Dto.getTransactionData().getTerminalCaptureCapacity()));
        Entity.setTerminalDataEntry(TerminalDataEntry.fromString(Dto.getTransactionData().getTerminalDataEntry()));
        Entity.setDate(TimeOfTransaction.fromString(Dto.getTransactionData().getDate()));

        Entity.setFullName(Dto.getFullName());
        Entity.setJoinDate(Dto.getJoinDate());
        Entity.setTransactionBankCardNumber(Dto.getTransactionBankCardEntity().getCardNumber());
        Entity.setTransactionBankAccountNumber(Dto.getTransactionBankAccountEntity().getAccountNumber());

    }


}

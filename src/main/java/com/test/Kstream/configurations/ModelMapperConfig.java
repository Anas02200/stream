package com.test.Kstream.configurations;

import com.test.Kstream.dataTransferObject.TransactionDataDto;
import com.test.Kstream.entities.BankTransactionEntity;
import com.test.Kstream.enums.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }

/*
    public PropertyMap<TransactionDataDto, BankTransactionEntity> propertyMap() {
        return new PropertyMap<TransactionDataDto, BankTransactionEntity>() {
            @Override
            protected void configure() {
                map().setTransactionActivity(Activity.fromString(source.getTransactionActivity()));
                map().setTransactionAmount(AmountOfTransaction.fromString(source.getTransactionAmount()));
                map().setAuthenticationMethod(AuthenticationMethod.fromString(source.getAuthenticationMethod()));
                map().setAuthorized(Authorization.fromString(source.getAuthorized()));
                map().setClientPresence(ClientPresence.fromString(source.getClientPresence()));
                map().setCountryOfTheCommerce(CountryOfTheCommerce.fromString(source.getCountryOfTheCommerce()));
                map().setProcessCode(ProcessCode.fromString(source.getProcessCode()));
                map().setResponseCode(ResponseCode.fromString(source.getResponseCode()));
                map().setTerminalCaptureCapacity(TerminalCaptureCapacity.fromString(source.getTerminalCaptureCapacity()));
                map().setTerminalDataEntry(TerminalDataEntry.fromString(source.getTerminalDataEntry()));
                map().setDate(TimeOfTransaction.fromString(source.getDate()));

            }
        };
    }

    ;
*/
}

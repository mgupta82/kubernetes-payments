package com.payment.router.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import iso.std.iso._20022.tech.xsd.pacs_008_001.ActiveCurrencyAndAmount;
import iso.std.iso._20022.tech.xsd.pacs_008_001.BranchAndFinancialInstitutionIdentification5;
import iso.std.iso._20022.tech.xsd.pacs_008_001.ContactDetails2;
import iso.std.iso._20022.tech.xsd.pacs_008_001.PartyIdentification125;
import iso.std.iso._20022.tech.xsd.pacs_008_001.PostalAddress6;

@Mapper(componentModel="spring")
public interface DocumentMapper {
	
	DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);
	
	iso.std.iso._20022.tech.xsd.pacs_002_001.BranchAndFinancialInstitutionIdentification5 convert(BranchAndFinancialInstitutionIdentification5 BranchAndFinancialInstitutionIdentification);
	
	iso.std.iso._20022.tech.xsd.pacs_002_001.ActiveOrHistoricCurrencyAndAmount convert(ActiveCurrencyAndAmount activeCurrencyAndAmount);
	
	iso.std.iso._20022.tech.xsd.pacs_002_001.PartyIdentification125 convert(PartyIdentification125 partyIdentification);
	
	iso.std.iso._20022.tech.xsd.pacs_002_001.PostalAddress6 convert(PostalAddress6 postalAddress);
	
	iso.std.iso._20022.tech.xsd.pacs_002_001.ContactDetails2 convert(ContactDetails2 contactDetails);
	
	
}

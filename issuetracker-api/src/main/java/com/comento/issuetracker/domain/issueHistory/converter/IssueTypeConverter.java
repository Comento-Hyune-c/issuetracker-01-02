package com.comento.issuetracker.domain.issueHistory.converter;

import com.comento.issuetracker.domain.issueHistory.constant.IssueType;
import java.util.EnumSet;
import java.util.NoSuchElementException;
import javax.persistence.AttributeConverter;

public class IssueTypeConverter implements AttributeConverter<IssueType, String> {

    @Override
    public String convertToDatabaseColumn(IssueType attribute) {
        return attribute.getCode();
    }

    @Override
    public IssueType convertToEntityAttribute(String dbData) {
        return EnumSet.allOf(IssueType.class).stream()
            .filter(e -> e.getCode().equals(dbData))
            .findAny()
            .orElseThrow(()-> new NoSuchElementException());
    }

}
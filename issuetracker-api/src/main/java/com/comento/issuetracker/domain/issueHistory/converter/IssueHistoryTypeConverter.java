package com.comento.issuetracker.domain.issueHistory.converter;

import com.comento.issuetracker.domain.issueHistory.constant.IssueHistoryType;
import java.util.EnumSet;
import java.util.NoSuchElementException;
import javax.persistence.AttributeConverter;

public class IssueHistoryTypeConverter implements AttributeConverter<IssueHistoryType, String> {

    @Override
    public String convertToDatabaseColumn(IssueHistoryType attribute) {
        return attribute.getCode();
    }

    @Override
    public IssueHistoryType convertToEntityAttribute(String dbData) {
        return EnumSet.allOf(IssueHistoryType.class).stream()
            .filter(e -> e.getCode().equals(dbData))
            .findAny()
            .orElseThrow(()-> new NoSuchElementException());
    }

}

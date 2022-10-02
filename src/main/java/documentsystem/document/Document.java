package documentsystem.document;

import documentsystem.constants.Attribute;
import documentsystem.constants.ImporterType;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.EnumMap;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class Document {
    private final EnumMap<Attribute, String> attributes;
    private final List<String> lines;
    private final ImporterType type;

    public String getAttributeValue(String attribute) {
        return attributes.get(attribute);
    }

    public boolean hasContained(String content) {
        if (type.equals(ImporterType.IMAGE)) return false;
        return lines.stream().filter(line -> line.contains(content)).count() > 0;
    }
}

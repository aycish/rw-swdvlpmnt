package documentsystem.document;

import documentsystem.constants.Attribute;
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

    public String getAttributeValue(String attribute) {
        return attributes.get(attribute);
    }

    public boolean hasContained(String content) {
        return lines.stream().filter(line -> line.contains(content)).count() > 0;
    }
}

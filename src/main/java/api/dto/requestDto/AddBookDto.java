package api.dto.requestDto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AddBookDto {
    String userId;
    IsbnDto[] collectionOfIsbns;
}

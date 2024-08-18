package mvn.example.lombok;


import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class StLombok {

    private int ani;
    @NonNull
    private String nume;
    private String familei;
    private String facultate;
    private int nmr;
}

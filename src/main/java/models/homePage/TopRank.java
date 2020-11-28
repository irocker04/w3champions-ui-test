package models.homePage;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TopRank {

    private int position;
    private String name;
    private int win;
    private int loss;
    private int total;
}

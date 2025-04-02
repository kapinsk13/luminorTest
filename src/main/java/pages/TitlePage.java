package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class TitlePage {
    private static final ElementsCollection actors = $$("[data-testid='title-cast-item__actor']");

    @Step("Get top cast")
    public static void getTopCast(int count) {
        List<String> topCast = new ArrayList<>();
        int limit = Math.min(count, actors.size());

        for (int i = 0; i < limit; i++) {
            SelenideElement actor = actors.get(i);
            topCast.add(actor.getText());
        }

        System.out.println("Top 5 cast members:");
        for (int i = 0; i < topCast.size(); i++) {
            System.out.println((i + 1) + ". " + topCast.get(i));
        }

        for (String actor : topCast) {
            Allure.addAttachment("Cast Member", actor);
        }
    }

}

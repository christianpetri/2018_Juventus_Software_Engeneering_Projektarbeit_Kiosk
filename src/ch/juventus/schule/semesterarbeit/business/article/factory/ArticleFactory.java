package ch.juventus.schule.semesterarbeit.business.article.factory;

import ch.juventus.schule.semesterarbeit.business.article.*;

/**
 * The article factory creates all the articles that can be bought in the kiosk and from the supplier
 *
 * @author : ${user}
 * @since: ${date}
 */
public class ArticleFactory {

    public Snacks createMars() {
        return new Snacks("Mars", 10, SnacksType.SWEET);
    }

    public Softdrink createBigAppleJuice() {
        return new Softdrink("Apfelsaft 1l", 5, 100);
    }

    public Alcohol createBigBeer() {
        return new Alcohol("Quellfrisch 5dl", 5, 5, 16);
    }

    public Alcohol createSmallVodka() {
        return new Alcohol("Vodka 3dl", 10, 3, 18);
    }

    public Alcohol createBigVodka() {
        return new Alcohol("Vodka 5dl", 6, 5, 18);
    }

    public Tobacco createCigarettePack() {
        return new Tobacco("Zigaretten", 10);
    }

    public Magazine createGlamourMagazin() {
        return new Magazine("Glamour Daily", 30, MagazineType.INTERNATIONAL);
    }
}

package ch.juventus.schule.semesterarbeit.business.item.factory;
import ch.juventus.schule.semesterarbeit.business.item.*;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class ArticleFactory {

    public Snacks createMars(){
        return new Snacks("Mars", 10, SnacksType.SWEET);
    }

    public Softdrink createBigAppleJuice(){
        return new Softdrink("Apfelsaft", 5, 100);
    }

    public Alcohol createBigBeer(){
        return new Alcohol("Quellfrisch", 5, 5,16);
    }

    public Alcohol createSmallVodka(){
        return new Alcohol("Vodka", 10, 5,18);
    }

    public Alcohol createBigVodka(){
        return new Alcohol("Vodka", 6, 3,18);
    }

    public Tobacco createCigarettePack(){
        return new Tobacco("Zigaretten", 10);
    }

    public Magazine createGlamourMagazin(){
        return new Magazine("Glamour Daily", 30, MagazineType.INTERNATIONAL);
    }
}
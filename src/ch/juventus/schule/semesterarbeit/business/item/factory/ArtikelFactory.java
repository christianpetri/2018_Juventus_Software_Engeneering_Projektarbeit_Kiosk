package ch.juventus.schule.semesterarbeit.business.item.factory;

import ch.juventus.schule.semesterarbeit.business.item.*;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class ArtikelFactory {

    public Snacks erzeugeMars(){
        return new Snacks("Mars", 10, SnacksType.SWEET);
    }

    public Softdrinks erzeugeGrosserApfelsaft(){
        return new Softdrinks("Apfelsaft", 5, 100);
    }

    public Alcohol erzeugeGrossesBier(){
        return new Alcohol("Quellfrisch", 5, 5,16);
    }

    public Alcohol erzeugeKleinerVodka(){
        return new Alcohol("Vodka", 10, 5,18);
    }

    public Alcohol erzeugeGrosserVodka(){
        return new Alcohol("Vodka", 3, 3,18);
    }

    public Tobacco erzeugeZigarettenPack(){
        return new Tobacco("Zigaretten", 10);
    }

    public BaseArticle erzeugeGlamourMagazin(){
        return new Magazine("Glamour Daily", 100, MagazineType.INTERNATIONAL);
    }
}

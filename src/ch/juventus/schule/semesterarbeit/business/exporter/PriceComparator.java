package ch.juventus.schule.semesterarbeit.business.exporter;

import ch.juventus.schule.semesterarbeit.business.article.BaseArticle;

import java.util.Comparator;

/**
 *  Orders the kiosk inventory articles by highest to lowest price
 * @author : ${user}
 * @since: ${date}
 */
public class PriceComparator implements Comparator<BaseArticle> {

    @Override
    public int compare(BaseArticle o1, BaseArticle o2) {
        return ((Integer) o2.getPrice()).compareTo(o1.getPrice());
    }
}

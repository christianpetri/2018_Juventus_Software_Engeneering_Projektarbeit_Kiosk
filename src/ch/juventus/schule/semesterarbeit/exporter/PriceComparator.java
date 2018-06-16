package ch.juventus.schule.semesterarbeit.exporter;

import ch.juventus.schule.semesterarbeit.business.item.BaseArticle;

import java.util.Comparator;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class PriceComparator implements Comparator<BaseArticle> {

    @Override
    public int compare(BaseArticle o1, BaseArticle o2) {
        return ((Integer) o2.getPrice()).compareTo(o1.getPrice());
    }
}

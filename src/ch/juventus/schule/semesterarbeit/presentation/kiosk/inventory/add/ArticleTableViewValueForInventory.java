package ch.juventus.schule.semesterarbeit.presentation.kiosk.inventory.add;

import ch.juventus.schule.semesterarbeit.business.item.BaseArticle;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class ArticleTableViewValueForInventory {
    private Kiosk kiosk;
    private BaseArticle baseArticle;
    private String articleAmountInInventory;
    private String articleAmountInShoppingBasket;
    private String articleDescription;
    private String articlePrice;
    private String removeArticle;
    private String addArticle;


    public ArticleTableViewValueForInventory(Kiosk kiosk, BaseArticle baseArticle, String articleAmountInInventory, String articleAmountInShoppingBasket, String articleDescription, String articlePrice) {
        this.kiosk = kiosk;
        this.baseArticle = baseArticle;
        this.articleAmountInInventory = articleAmountInInventory;
        this.articleAmountInShoppingBasket = articleAmountInShoppingBasket;
        this.articleDescription = articleDescription;
        this.articlePrice = articlePrice;
        this.removeArticle = "-";
        this.addArticle = "+";
    }

    public Kiosk getKiosk() {
        return kiosk;
    }

    public BaseArticle getBaseArticle() {
        return baseArticle;
    }

    public String getArticleAmountInInventory() {
        return articleAmountInInventory;
    }

    public String getArticleAmountInShoppingBasket() {
        return articleAmountInShoppingBasket;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public String getArticlePrice() {
        return articlePrice;
    }

    public String getRemoveArticle() {
        return removeArticle;
    }

    public String getAddArticle() {
        return addArticle;
    }
}

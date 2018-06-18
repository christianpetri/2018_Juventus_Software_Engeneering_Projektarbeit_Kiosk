package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;
import ch.juventus.schule.semesterarbeit.business.item.BaseArticle;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class ArticleTableViewValue {
    private Kiosk kiosk;
    private Customer customer;
    private BaseArticle baseArticle;
    private int articleAmountInInventory;
    private int articleAmountInShoppingBasket;
    private String articleDescription;
    private String articlePrice;
    private String removeArticle;
    private String addArticle;


    public ArticleTableViewValue(Kiosk kiosk, Customer customer, BaseArticle baseArticle, int articleAmountInInventory, int articleAmountInShoppingBasket, String articleDescription, String articlePrice) {
        this.kiosk = kiosk;
        this.customer = customer;
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

    public Customer getCustomer() {
        return customer;
    }

    public BaseArticle getBaseArticle() {
        return baseArticle;
    }

    public int getArticleAmountInInventory() {
        return articleAmountInInventory;
    }

    public int getArticleAmountInShoppingBasket() {
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

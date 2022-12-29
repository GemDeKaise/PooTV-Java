package pages;

import java.util.List;

/**
 * Store the pages of the application.
 */
public enum PageEnum {
    LOGIN("login"),
    REGISTER("register"),
    HOMEPAGE("home page"),
    LOGOUT("logout"),
    MOVIES("movies"),
    UPGRADES("upgrades"),
    SEE_DETAILS("see details"),
    ERROR("Error");

    private final String value;

    PageEnum(final String value) {
        this.value = value;
    }

    /**
     * Get the page enum from the given list of pages.
     * @param pages the list of pages
     * @param value the value of the page
     * @return the page enum
     */
    public static PageEnum getPage(final List<PageEnum> pages, final String value) {
        for (PageEnum page : pages) {
            if (page.value.equals(value)) {
                return page;
            }
        }
        return ERROR;
    }
}

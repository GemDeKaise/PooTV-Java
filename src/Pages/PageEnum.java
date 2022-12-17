package src.Pages;

import java.util.List;

public enum PageEnum {
	LOGIN ("login"),
	REGISTER("register"),
	HOMEPAGE ("home page"),
	LOGOUT ("logout"),
	MOVIES ("movies"),

	UPGRADES ("upgrades"),
	SEE_DETAILS ("see details"),
	ERROR ("Error");

	public String value;

	PageEnum(String value) {
		this.value = value;
	}

	public static PageEnum getPage(List<PageEnum> pages, String value) {
		for (PageEnum page : pages) {
			if (page.value.equals(value)) {
				return page;
			}
		}
		return ERROR;
	}
}

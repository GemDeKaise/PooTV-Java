package src;

import java.util.List;

public enum PageNames {
	LOGIN ("login"),
	REGISTER("register"),
	HOMEPAGE ("home page"),
	LOGOUT ("logout"),
	MOVIES ("movies"),
	UPGRADES ("upgrades"),
	SEE_DETAILS ("see details"),
	ERROR ("Error");

	public String value;

	PageNames(String value) {
		this.value = value;
	}

	public static PageNames getPage(List<PageNames> pages, String value) {
		for (PageNames page : pages) {
			if (page.value.equals(value)) {
				return page;
			}
		}
		return ERROR;
	}
}

package jp.javelindev;

import jp.javelindev.snippet.CustomErrorPage;
import jp.javelindev.snippet.ExpireAjaxPage;
import org.apache.wicket.markup.html.pages.PageExpiredErrorPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see jp.javelindev.Start#main(String[])
 */
public class WicketApplication extends WebApplication {

    /**
     * Constructor
     */
    public WicketApplication() {
    }

    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<ExpireAjaxPage> getHomePage() {
        return ExpireAjaxPage.class;
    }

    @Override
    protected void init() {
        super.init();

        getMarkupSettings().setDefaultMarkupEncoding("UTF-8");
        getRequestCycleSettings().setResponseRequestEncoding("UTF-8");

        mountBookmarkablePage("expired", PageExpiredErrorPage.class);
        mountBookmarkablePage("pageExpired", CustomErrorPage.class);
    }
}

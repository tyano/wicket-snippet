/*
 * Copyright 2011 Tsutomu YANO.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.javelindev.snippet;

import jp.javelindev.snippet.validator.CombinationalValidator;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.PatternValidator;
import org.apache.wicket.validation.validator.StringValidator;

/**
 *
 * @author Tsutomu YANO
 */
public class ValidatorPage extends WebPage {
    private static final long serialVersionUID = 1L;

    public ValidatorPage(PageParameters parameters) {
        super(parameters);
        IModel<String> model = new Model<String>();
        Form<Void> form = new Form<Void>("form");
        TextField<String> text = new TextField<String>("text", model);

        text.add(new CombinationalValidator<String>()
                .add(StringValidator.maximumLength(3))
                .add(new PatternValidator("\\d*")));
        form.add(text);

        FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
        form.add(feedbackPanel);

        add(form);
    }
}

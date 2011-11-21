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
package jp.javelindev.snippet.validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;

/**
 *
 * @author Tsutomu YANO
 */
public class CombinationalValidator<T> implements IValidator<T> {
    private static final long serialVersionUID = 1L;
	private final List<IValidator<T>> validators = new ArrayList<IValidator<T>>(2);

	/**
	 * Constructor.
	 */
	public CombinationalValidator()
	{
	}

	/**
	 * Adds an <code>IValidator</code> to the chain of validators.
	 *
	 * @param validator
	 *            an <code>IValidator</code> to be added
	 * @return this <code>ValidationError</code> for chaining purposes
	 */
	public final CombinationalValidator<T> add(IValidator<T> validator)
	{
		if (validator == null)
		{
			throw new IllegalArgumentException("Argument `validator` cannot be null");
		}
		validators.add(validator);
		return this;
	}

	/**
	 * @see IValidator#validate(IValidatable)
	 */
    @Override
	public final void validate(IValidatable<T> validatable)
	{
		Iterator<IValidator<T>> it = validators.iterator();
		while (it.hasNext())
		{
			it.next().validate(validatable);
		}
	}

	/**
	 * Gets an unmodifiable list of the registered validators.
	 *
	 * @return unmodifiable list of delegate {@link IValidator}s inside this one
	 */
	public final List<IValidator<T>> getValidators()
	{
		return Collections.unmodifiableList(validators);
	}
}

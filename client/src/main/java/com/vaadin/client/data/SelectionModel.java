/*
 * Copyright 2000-2016 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.client.data;

import java.util.Set;

import com.vaadin.shared.data.DataCommunicatorConstants;

import elemental.json.JsonObject;

/**
 * Models the selection logic of a {@code Grid} component. Determines how items
 * can be selected and deselected.
 *
 * @author Vaadin Ltd.
 *
 * @param <T>
 *            the type of the items to select
 * @since 8.0
 */
public interface SelectionModel<T> {

    /**
     * Selects the given item. If another item was already selected, that item
     * is deselected.
     *
     * @param item
     *            the item to select, not null
     */
    void select(T item);

    /**
     * Deselects the given item. If the item is not currently selected, does
     * nothing.
     *
     * @param item
     *            the item to deselect, not null
     */
    void deselect(T item);

    /**
     * Returns a set of the currently selected items. It is safe to invoke other
     * {@code SelectionModel} methods while iterating over the set.
     *
     * @return the items in the current selection, not null
     */
    Set<T> getSelectedItems();

    /**
     * Returns whether the given item is currently selected.
     *
     * @param item
     *            the item to check, not null
     * @return {@code true} if the item is selected, {@code false} otherwise
     */
    boolean isSelected(T item);

    /**
     * Deselects all currently selected items.
     */
    default void deselectAll() {
        getSelectedItems().forEach(this::deselect);
    }

    /**
     * Gets the selected state from a given grid row json object. This is a
     * helper method for grid selection models.
     *
     * @param item
     *            a json object
     * @return {@code true} if the json object is marked as selected;
     *         {@code false} if not
     */
    public static boolean isItemSelected(JsonObject item) {
        return item.hasKey(DataCommunicatorConstants.SELECTED)
                && item.getBoolean(DataCommunicatorConstants.SELECTED);
    }

}

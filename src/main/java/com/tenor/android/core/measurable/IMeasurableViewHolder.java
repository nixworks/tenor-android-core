package com.tenor.android.core.measurable;

import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

/**
 * Interface of a {@link RecyclerView.ViewHolder}, measure {@link MeasurableViewHolderData} of a {@link RecyclerView.ViewHolder}
 * <p>
 * (1) Implementations of methods in this {@link IMeasurableViewHolder} are recommended to be synchronized
 * <p>
 * (2) {@link MeasurableViewHolderData} must be initialized on constructor
 */
public interface IMeasurableViewHolder extends IViewHolder {

    /**
     * @return visible fraction of the item view
     */
    @FloatRange(from = 0f, to = 1f)
    float measure(@NonNull RecyclerView recyclerView);

    void attachMeasurer(@NonNull RecyclerView recyclerView);

    /**
     * Resume the measurer to collect {@link MeasurableViewHolderData} on referenced view resumed
     */
    void resumeMeasurer(@NonNull RecyclerView recyclerView);

    /**
     * Pause the measurer to collect {@link MeasurableViewHolderData} on referenced view paused
     */
    void pauseMeasurer(@NonNull RecyclerView recyclerView);

    /**
     * Destroy {@link MeasurableViewHolderData} on the itemView of a
     * {@link RecyclerView.ViewHolder} detached from window
     */
    void detachMeasurer();

    /**
     * Return true if the {@link RecyclerView.ViewHolder} has been attached from the {@link RecyclerView}
     */
    boolean isAttached();

    /**
     * Return true if the {@link RecyclerView.ViewHolder} has been detached from the {@link RecyclerView}
     */
    boolean isDetached();

    void flush();
}


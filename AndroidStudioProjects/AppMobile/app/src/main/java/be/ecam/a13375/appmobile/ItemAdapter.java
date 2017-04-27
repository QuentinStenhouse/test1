package be.ecam.a13375.appmobile;

/**
 * Created by Paluche on 27-04-17.
 */

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Paluche on 27-04-17.
 */


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterViewHolder> {

    private ArrayList<ContactsContract.Contacts.Data> mData = null;
    private ItemAdapterOnClickHandler clickHandler;

    public ItemAdapter(ItemAdapterOnClickHandler clickHandler) {
        this.clickHandler = clickHandler;
    }

    public interface ItemAdapterOnClickHandler {
        void onClick(int index);
    }

    public class ItemAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView mTextView;

        public ItemAdapterViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.city_name);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            clickHandler.onClick(adapterPosition);
        }
    }

    @Override
    public ItemAdapterViewHolder onCreateViewHolder
            (ViewGroup viewGroup, int viewType) {

        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.item_list;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem,
                viewGroup, shouldAttachToParentImmediately);
        return new ItemAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder
            (ItemAdapterViewHolder itemAdapterViewHolder, int position) {

        Data dataForThisItem = mData.get(position);
        itemAdapterViewHolder.mTextView.setText(dataForThisItem.getDate());
    }

    @Override
    public int getItemCount() {
        if (null == mData) return 0;
        return mData.size();
    }

    public void setData(String data) throws JSONException {
        Data.parse(data);
        mData = Data.DataList();
        notifyDataSetChanged();
    }
}
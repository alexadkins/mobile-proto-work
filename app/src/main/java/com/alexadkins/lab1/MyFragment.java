package com.alexadkins.lab1;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by alexadkins on 9/11/14.
 */
public class MyFragment extends Fragment {
    public MyFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        final ListView myListView = (ListView) rootView.findViewById(R.id.my_list_view);

        //FIXME - THESE ARE HARDCODED
//        String[] listChats = {"Chat", "List", "So", "What", "Yea"};
        final ArrayList<String> chatArray = new ArrayList<String>();
        final ChatAdapter adapter = new ChatAdapter(getActivity(), R.layout.chat_item,
                chatArray
//                new ArrayList<String>(Arrays.asList(listChats))

        );
//        chatArray.add("abc123");
        myListView.setAdapter(adapter);

        Button button = (Button) rootView.findViewById(R.id.submit_button);
        final EditText editText = (EditText) rootView.findViewById(R.id.user_text);

        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          Log.v("EditText", editText.getText().toString());
                                          chatArray.add(editText.getText().toString());
                                          editText.setText("");
                                          adapter.notifyDataSetChanged();
                                          myListView.setSelection(adapter.getCount() - 1);
                                      }
                                  });
//                chatArray.add(editText));




//        rootView.findViewById(R.id.my_text);
        return rootView;
    }

//    EditText editText = (EditText) findViewById(R.id.search);
//    editText.setOnEditorActionListener(new OnEditorActionListener() {
//        @Override
//        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//            boolean handled = false;
//            if (actionId == EditorInfo.IME_ACTION_SEND) {
//                sendMessage();
//                handled = true;
//            }
//            return handled;
//        }
//    });

}

//get an implementation of a chatbox working. it should have a ListView that has a list of "chat" items
//Use an ArrayAdapter to fill the ListView
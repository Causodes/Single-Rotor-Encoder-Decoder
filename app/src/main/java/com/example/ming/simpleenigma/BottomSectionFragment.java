package com.example.ming.simpleenigma;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BottomSectionFragment extends Fragment{

    private static TextView finalMessage;
    public static char encryptionTable[];
    public static String rotor1;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        char table[] = {'=', '8', '~', '@', '.', '*', '0', 'p', 's', '{', '}', 'j', 't', 'e', 'y', 'u', 'b', 'g', ']',
                '3', '#', '`', 'q', '9', 'i', '_', '/', '2', 'h', '"', ' ', '$', 'd', 'z', '>', '+', '<', 'c', '|', '?', 'r', ')',
                '7', 'a', 'f', '-', '\\', ';', 'w', 'v', '5', ',', 'x', 'k', '%', '[', '&', 'n', 'l', '6', '(', 'm', '1', 'o', '4', '\''};
        encryptionTable = table;

        String rotorString;
        rotorString = "6\";psvi}x,`[+o>kw\'\\g48m_$y=1<n(2e#zf%~h/ur3caj?]l|&)70 dt@bq.9-5*{";
        rotor1 = rotorString;

        View view = inflater.inflate(R.layout.bottom_layout_fragment, container, false);
        finalMessage = (TextView) view.findViewById(R.id.finalMessage);
        return view;
    }

    public void encrypt(String top, String bottom){

        String encryptedMessage; //final encrypted message
        int messagePosition = -1; //position of letter in original message
        int keyPosition; //position of letter in key
        int combinedPosition; //both positions added together
        int rotorStartPosition;
        char letter;
        char keyLetter;
        top = top.toLowerCase(); //changes message to lowercase
        rotorStartPosition = Integer.parseInt(bottom) % rotor1.length();
        int flag = 0; //flag for unknown character

        encryptedMessage = "";

        for(int i = 0; i < top.length(); i++) //for loop for traversing message
        {
            letter = top.charAt(i);
            messagePosition = mappingTablePosition(letter);
            keyLetter = rotor1.charAt(i % rotor1.length());
            keyPosition = mappingTablePosition(keyLetter);
            combinedPosition = messagePosition + keyPosition + rotorStartPosition;
            encryptedMessage = encryptedMessage + encryptionTable[combinedPosition % encryptionTable.length];
        }
        finalMessage.setText(encryptedMessage);
    }

    public void decrypt(String top, String bottom){

        String decryptedMessage;
        int codedMessagePosition;
        int keyPosition;
        int rotorStartPosition;
        char letter;
        char keyLetter;
        top = top.toLowerCase();
        rotorStartPosition = Integer.parseInt(bottom) % rotor1.length();

        decryptedMessage = "";

        for(int i = 0; i < top.length(); i++)
        {
            letter = top.charAt(i);
            codedMessagePosition = mappingTablePosition(letter);
            keyLetter = rotor1.charAt(i % rotor1.length());
            keyPosition = mappingTablePosition(keyLetter);
            decryptedMessage = decryptedMessage + encryptionTable[(codedMessagePosition + 2 * encryptionTable.length - keyPosition - rotorStartPosition) % encryptionTable.length];
        }
        finalMessage.setText(decryptedMessage);
    }

    private int mappingTablePosition(char c){

        int pos = -1;

        for(int i = 0; i < encryptionTable.length; i++)
        {
            if(c == encryptionTable[i])
            {
                pos = i;
                break;
            }
        }
        return pos;
    }

}



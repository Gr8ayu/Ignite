package com.example.ignite;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DetailActivity extends AppCompatActivity {
    private Integer imageID;
    private ArrayList<keyValue> keyvalues = new ArrayList<>();
    private String descriptionText;
    private ArrayList<keyValue> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getContent();
        displayContent();






    }

    private void getContent(){

        String type = getIntent().getExtras().getString("type");

        switch (type){
            case "Bharatiya Janata Party":bjp();break;
            case "Indian National Congress":inc();break;
            case "All India Trinamool Congress":aitmc();break;
            case "Bahujan Samaj Party":bsp();break;
            case "Communist Party of India":cpi();break;
            case "Communist Party of India (Marxist)":cpim();break;
            case "Nationalist Congress Party":ncp();break;


            case "Narendra Modi":namo();break;
            case "Rahul Gandhi":raga();break;
            case "Amit Shah":amitshah();break;
            case "Mayavati":mayavati();break;
            case "Arvind Kejriwal":arvind();break;
            case "L K Advani":lkadvani();break;
            case "Sushma Swaraj":sushma();break;
            case "Sonia Gandhi":sonia();break;
            case "Smriti Irani":smriti();break;

        }

    }

    private void displayContent(){
        ImageView logoImage = (ImageView) findViewById(R.id.logoImage);
        logoImage.setImageResource(imageID);

        Log.v("this",keyvalues.toString());
        Iterator<keyValue> it = keyvalues.iterator();
        while (it.hasNext()) {
            keyValue temp = it.next();
            LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = vi.inflate(R.layout.keyvaluepair, null);

            // fill in any details dynamically here
            TextView key = (TextView) v.findViewById(R.id.key);
            key.setText(temp.getKey());
            TextView value = (TextView) v.findViewById(R.id.value);
            value.setText(temp.getValue());

            // insert into main view
            ViewGroup insertPoint = (ViewGroup) findViewById(R.id.keyValues);
            insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

        }

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(descriptionText);

        // Key details
        Iterator<keyValue> ite = contacts.iterator();

        while (ite.hasNext()) {
            final keyValue temp = ite.next();
            LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = vi.inflate(R.layout.keyvaluepair, null);

            // fill in any details dynamically here
            TextView key = (TextView) v.findViewById(R.id.key);
            key.setText(temp.getKey());
            TextView value = (TextView) v.findViewById(R.id.value);
            value.setText(temp.getValue());

            value.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url ="http://"+ temp.getValue();
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                }
            });

            // insert into main view
            ViewGroup insertPoint = (ViewGroup) findViewById(R.id.contacts);
            insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

        }
    }

    private void bjp(){

        imageID = R.drawable.bjp;
        keyvalues = new ArrayList<>();
        keyvalues.add(new keyValue("Abbreviation","BJP"));
        keyvalues.add(new keyValue("President","Amit Shah"));
        keyvalues.add(new keyValue("Parliamentary Chairperson","Narendra Modi"));
        keyvalues.add(new keyValue("Founded","6 April 1980"));
        keyvalues.add(new keyValue("Ideology","Hindutva\n" +
        "Hindu nationalism\n" +
        "Integral humanism\n" +
        "National conservatism\n" +
        "Social conservatism\n" +
        "Economic nationalism\n" +
        "Right-wing populism"));
        keyvalues.add(new keyValue("Alliance","National Democratic Alliance (NDA)"));
        keyvalues.add(new keyValue("Seats in Lok Sabha","271 / 545"));
        keyvalues.add(new keyValue("Seats in Rajya Sabha","73 / 245"));
        Collections.reverse(keyvalues);

        descriptionText = "The Bharatiya Janata Party (BJP), translated into English as the “Indian People's Party”, is one of the prominent parties in India today. It is a major political party with a right-wing political position. It strongly adheres to cultural nationalism through social conservatism and integral humanism. It is the most significant member of the family of active organisations known as the 'Sangh Parivar'. The BJP was officially formed in 1980, under the political guidance and leadership of two of its most significant leaders, Atal Bihari Vajpayee and L.K. Advani. Both of them were members of the Bharatiya Jana Sangh (BJS), the political wing of the Rashtriya Swayamsevak Sangh (RSS), nationalist cultural organisation of independent India. The BJS was founded by Dr. Shyama Prasad Mookherjee in 1951, to combat the increasing political power of the Indian National Congress (INC), which was said to have initiated a number of compromises in the questions of political and cultural integrity and unity of India, such as appeasement policy for Muslims. The BJS, under the umbrella of RSS, began to grow in strength. But soon after, with Mookherjee's death, the organisation started to decline in political importance";

        contacts = new ArrayList<>();
        contacts.clear();
        contacts.add(new keyValue("facebook","www.facebook.com/BJP4India"));
        contacts.add(new keyValue("twitter","www.twitter.com/BJP4India"));
        contacts.add(new keyValue("website","www.bjp.org"));
        Collections.reverse(contacts);




    }

    private void inc(){

        imageID = R.drawable.inc;

        keyvalues.add(new keyValue("Abbreviation","INC"));
        keyvalues.add(new keyValue("President","Rahul Gandhi"));
        keyvalues.add(new keyValue("Parliamentary Chairperson","Sonia Gandhi"));
        keyvalues.add(new keyValue("Founded","28 December 1885"));
        keyvalues.add(new keyValue("Ideology","Social democracy\n" +
                "Democratic socialism\n" +
                "Social liberalism\n" +
                "Hindu left[6]\n" +
                "Swadeshi movement\n" +
                "Gandhian socialism\n" +
                "Secularism\n" +
                "Progressivism"));
        keyvalues.add(new keyValue("Alliance","United Progressive Alliance (UPA)"));
        keyvalues.add(new keyValue("Seats in Lok Sabha","47 / 545"));
        keyvalues.add(new keyValue("Seats in Rajya Sabha","50 / 245"));
        Collections.reverse(keyvalues);

        descriptionText = "Indian National Congress, byname Congress Party, broadly based political party of India. Formed in 1885, the Indian National Congress dominated the Indian movement for independence from Great Britain. It subsequently formed most of India’s governments from the time of independence and often had a strong presence in many state governments. The Congress Party is a hierarchically structured party. Delegates from state and district parties attend an annual national conference, which elects a president and the All India Congress Committee. However, the 20-member Congress Working Committee, the majority of whose members are appointed by the party president (handpicked by the prime minister when the party is in power), wields enormous influence. The party is also organized into various committees and sections (e.g., youth and women’s groups), and it publishes a daily newspaper, the National Herald. Mirroring the party’s declining fortunes, the party’s membership dropped from nearly 40 million in the mid-1990s to under 20 million at the beginning of the 21st century.";

        contacts = new ArrayList<>();
         
        contacts.add(new keyValue("facebook","www.facebook.com/IndianNationalCongress"));
        contacts.add(new keyValue("twitter","www.twitter.com/INCIndia"));
        contacts.add(new keyValue("website","www.inc.in"));
        Collections.reverse(contacts);

    }

    private void aitmc(){

        imageID = R.drawable.aitmc;

        keyvalues.add(new keyValue("Abbreviation","AITC"));
        keyvalues.add(new keyValue("President","Mamata Banerjee"));
        keyvalues.add(new keyValue("Secretary-General",	"Subrata Bakshi"));
        keyvalues.add(new keyValue("Founded","1 January 1998"));
        keyvalues.add(new keyValue("Ideology","Democratic Socialism\n" +
                "Regionalism\n" +
                "Civic nationalism\n" +
                "Secularism\n" +
                "Anti-communism"));
        keyvalues.add(new keyValue("Alliance","Third Front"));
        keyvalues.add(new keyValue("Seats in Lok Sabha","36 / 545"));
        keyvalues.add(new keyValue("Seats in Rajya Sabha","13 / 245"));
        Collections.reverse(keyvalues);

        descriptionText = "The All India Trinamool Congress (abbreviated AITC or TMC) is a national level political party in India. Founded on 1 January 1998, the party is led by its founder Mamata Banerjee, who is the current chief minister of West Bengal. Following the 2014 general election, it is currently the fourth largest party in the Lok Sabha with 36 seats. After being a member of the Indian National Congress for over 26 years, Mamata Banerjee formed her own party of Bengal, the \"Trinamool Congress\", which was registered with the Election Commission of India during mid-December 1999. The Election Commission allotted to the party an exclusive symbol of Jora Ghas Phul. On 2 September 2016 election commission recognized AITC as a national political party.";

        contacts = new ArrayList<>();
         
        contacts.add(new keyValue("facebook","www.facebook.com/AITCofficial"));
        contacts.add(new keyValue("twitter","twitter.com/AITCofficial"));
        contacts.add(new keyValue("website","www.aitcofficial.org"));
        Collections.reverse(contacts);

    }

    private void bsp(){

        imageID = R.drawable.bsp;

        keyvalues.add(new keyValue("Abbreviation","BSP"));
        keyvalues.add(new keyValue("President","Mayawati"));
        keyvalues.add(new keyValue("Secretary-General","Satish Chandra Mishra"));
        keyvalues.add(new keyValue("Founded","14 April 1984"));
        keyvalues.add(new keyValue("Ideology","Affirmative action \n" +
                "Human rights\n" +
                "Social equality\n" +
                "Secularism\n" +
                "Social justice\n" +
                "Self respect"));
        keyvalues.add(new keyValue("Alliance","BSP-SP-RLD Alliance"));
        keyvalues.add(new keyValue("Seats in Lok Sabha","0 / 545"));
        keyvalues.add(new keyValue("Seats in Rajya Sabha","4 / 245"));
        Collections.reverse(keyvalues);

        descriptionText = "The Bahujan Samaj Party (BSP) is a national political party in India. In terms of vote share in the 2014 general election, it is the country's third-largest national party, even though it did not win any seats in the Lok Sabha.[7] It was formed mainly to represent Bahujans (literally meaning \"People in majority\"), referring to people from the Scheduled Castes, Scheduled Tribes and Other Backward Castes (OBC), as well as religious minorities that together, according to Kanshi Ram at the time he founded the party in 1984, comprised 85 percent of India's population but was divided into 6,000 different castes.[8][9]\n" +
                "Influential figures\n" +
                "\n" +
                "Jyotirao Phule, an Indian activist, thinker, social reformer from Maharashtra. He fought for the eradication of untouchability and the caste system, women's emancipation and the reform of Hindu family life. He also formed the Satyashodhak Samaj (Society of Seekers of Truth) to attain equal rights for peasants and people from lower castes.\n" +
                "\n" +
                "B. R. Ambedkar, chief architect of Indian Constitution and first law minister of India who campaigned against untouchability, caste system and also campaigned for the rights of women and laborers.\n" +
                "\n" +
                "Narayana Guru (ca. 1854 – 20 September 1928), was a social reformer of India. He was born into a family of the Ezhava caste in an era when people from such communities, which were regarded as Avarna, faced much injustice in the caste-ridden society of Kerala. He led a reform movement in Kerala, rejected casteism, and promoted new values of spiritual freedom and social equality.\n" +
                "\n" +
                "Periyar E. V. Ramasamy, an Indian social activist, freedom fighter and politician who started the Self-Respect Movement. He is known as the 'Father of modern Tamil Nadu'. He has done exemplary works against Brahminical dominance, caste prevalence and women oppression in Tamil Nadu.\n" +
                "\n" +
                "Chhatrapati Shahuji Maharaj was of Indian princely state of Kolhapur. He worked tirelessly for the cause of the lower caste subjects in his state. Primary education to all regardless of caste and creed was one of his most significant priorities.\n" +
                "The party claims to be inspired by the philosophy of Gautama Buddha, B. R. Ambedkar, Mahatma Jyotiba Phule, Narayana Guru, Periyar E. V. Ramasamy and Chhatrapati Shahuji Maharaj.[10] Kanshi Ram named his protégée Mayawati as his successor in 2001.";

        contacts = new ArrayList<>();
         
        contacts.add(new keyValue("facebook","www.facebook.com/BSP4BHARAT/"));
        contacts.add(new keyValue("twitter","www.twitter.com/bsp4india"));
        contacts.add(new keyValue("website","www.bspindia.org/"));
        Collections.reverse(contacts);

    }

    private void cpi(){

        imageID = R.drawable.cpi;

        keyvalues.add(new keyValue("Abbreviation","INC"));
        keyvalues.add(new keyValue("President","Rahul Gandhi"));
        keyvalues.add(new keyValue("Parliamentary Chairperson","Sonia Gandhi"));
        keyvalues.add(new keyValue("Founded","28 December 1885"));
        keyvalues.add(new keyValue("Ideology","Social democracy\n" +
                "Democratic socialism\n" +
                "Social liberalism\n" +
                "Hindu left[6]\n" +
                "Swadeshi movement\n" +
                "Gandhian socialism\n" +
                "Secularism\n" +
                "Progressivism"));
        keyvalues.add(new keyValue("Alliance","United Progressive Alliance (UPA)"));
        keyvalues.add(new keyValue("Seats in Lok Sabha","47 / 545"));
        keyvalues.add(new keyValue("Seats in Rajya Sabha","50 / 245"));
        Collections.reverse(keyvalues);

        descriptionText = "Indian National Congress, byname Congress Party, broadly based political party of India. Formed in 1885, the Indian National Congress dominated the Indian movement for independence from Great Britain. It subsequently formed most of India’s governments from the time of independence and often had a strong presence in many state governments. The Congress Party is a hierarchically structured party. Delegates from state and district parties attend an annual national conference, which elects a president and the All India Congress Committee. However, the 20-member Congress Working Committee, the majority of whose members are appointed by the party president (handpicked by the prime minister when the party is in power), wields enormous influence. The party is also organized into various committees and sections (e.g., youth and women’s groups), and it publishes a daily newspaper, the National Herald. Mirroring the party’s declining fortunes, the party’s membership dropped from nearly 40 million in the mid-1990s to under 20 million at the beginning of the 21st century.";

        contacts = new ArrayList<>();
         
        contacts.add(new keyValue("facebook","www.facebook.com/IndianNationalCongress"));
        contacts.add(new keyValue("twitter","www.twitter.com/INCIndia"));
        contacts.add(new keyValue("website","www.inc.in"));
        Collections.reverse(contacts);

    }

    private void cpim(){

        imageID = R.drawable.cpim;

        keyvalues.add(new keyValue("Abbreviation","INC"));
        keyvalues.add(new keyValue("President","Rahul Gandhi"));
        keyvalues.add(new keyValue("Parliamentary Chairperson","Sonia Gandhi"));
        keyvalues.add(new keyValue("Founded","28 December 1885"));
        keyvalues.add(new keyValue("Ideology","Social democracy\n" +
                "Democratic socialism\n" +
                "Social liberalism\n" +
                "Hindu left[6]\n" +
                "Swadeshi movement\n" +
                "Gandhian socialism\n" +
                "Secularism\n" +
                "Progressivism"));
        keyvalues.add(new keyValue("Alliance","United Progressive Alliance (UPA)"));
        keyvalues.add(new keyValue("Seats in Lok Sabha","47 / 545"));
        keyvalues.add(new keyValue("Seats in Rajya Sabha","50 / 245"));
        Collections.reverse(keyvalues);

        descriptionText = "Indian National Congress, byname Congress Party, broadly based political party of India. Formed in 1885, the Indian National Congress dominated the Indian movement for independence from Great Britain. It subsequently formed most of India’s governments from the time of independence and often had a strong presence in many state governments. The Congress Party is a hierarchically structured party. Delegates from state and district parties attend an annual national conference, which elects a president and the All India Congress Committee. However, the 20-member Congress Working Committee, the majority of whose members are appointed by the party president (handpicked by the prime minister when the party is in power), wields enormous influence. The party is also organized into various committees and sections (e.g., youth and women’s groups), and it publishes a daily newspaper, the National Herald. Mirroring the party’s declining fortunes, the party’s membership dropped from nearly 40 million in the mid-1990s to under 20 million at the beginning of the 21st century.";

        contacts = new ArrayList<>();
         
        contacts.add(new keyValue("facebook","www.facebook.com/IndianNationalCongress"));
        contacts.add(new keyValue("twitter","www.twitter.com/INCIndia"));
        contacts.add(new keyValue("website","www.inc.in"));
        Collections.reverse(contacts);

    }

    private void ncp(){

        imageID = R.drawable.ncp;

        keyvalues.add(new keyValue("Abbreviation","INC"));
        keyvalues.add(new keyValue("President","Rahul Gandhi"));
        keyvalues.add(new keyValue("Parliamentary Chairperson","Sonia Gandhi"));
        keyvalues.add(new keyValue("Founded","28 December 1885"));
        keyvalues.add(new keyValue("Ideology","Social democracy\n" +
                "Democratic socialism\n" +
                "Social liberalism\n" +
                "Hindu left[6]\n" +
                "Swadeshi movement\n" +
                "Gandhian socialism\n" +
                "Secularism\n" +
                "Progressivism"));
        keyvalues.add(new keyValue("Alliance","United Progressive Alliance (UPA)"));
        keyvalues.add(new keyValue("Seats in Lok Sabha","47 / 545"));
        keyvalues.add(new keyValue("Seats in Rajya Sabha","50 / 245"));
        Collections.reverse(keyvalues);

        descriptionText = "Indian National Congress, byname Congress Party, broadly based political party of India. Formed in 1885, the Indian National Congress dominated the Indian movement for independence from Great Britain. It subsequently formed most of India’s governments from the time of independence and often had a strong presence in many state governments. The Congress Party is a hierarchically structured party. Delegates from state and district parties attend an annual national conference, which elects a president and the All India Congress Committee. However, the 20-member Congress Working Committee, the majority of whose members are appointed by the party president (handpicked by the prime minister when the party is in power), wields enormous influence. The party is also organized into various committees and sections (e.g., youth and women’s groups), and it publishes a daily newspaper, the National Herald. Mirroring the party’s declining fortunes, the party’s membership dropped from nearly 40 million in the mid-1990s to under 20 million at the beginning of the 21st century.";

        contacts = new ArrayList<>();
         
        contacts.add(new keyValue("facebook","www.facebook.com/IndianNationalCongress"));
        contacts.add(new keyValue("twitter","www.twitter.com/INCIndia"));
        contacts.add(new keyValue("website","www.inc.in"));
        Collections.reverse(contacts);

    }

    private void namo(){

        imageID = R.drawable.namo;

        keyvalues.add(new keyValue("Abbreviation","INC"));
        keyvalues.add(new keyValue("President","Rahul Gandhi"));
        keyvalues.add(new keyValue("Parliamentary Chairperson","Sonia Gandhi"));
        keyvalues.add(new keyValue("Founded","28 December 1885"));
        keyvalues.add(new keyValue("Ideology","Social democracy\n" +
                "Democratic socialism\n" +
                "Social liberalism\n" +
                "Hindu left[6]\n" +
                "Swadeshi movement\n" +
                "Gandhian socialism\n" +
                "Secularism\n" +
                "Progressivism"));
        keyvalues.add(new keyValue("Alliance","United Progressive Alliance (UPA)"));
        keyvalues.add(new keyValue("Seats in Lok Sabha","47 / 545"));
        keyvalues.add(new keyValue("Seats in Rajya Sabha","50 / 245"));
        Collections.reverse(keyvalues);

        descriptionText = "Indian National Congress, byname Congress Party, broadly based political party of India. Formed in 1885, the Indian National Congress dominated the Indian movement for independence from Great Britain. It subsequently formed most of India’s governments from the time of independence and often had a strong presence in many state governments. The Congress Party is a hierarchically structured party. Delegates from state and district parties attend an annual national conference, which elects a president and the All India Congress Committee. However, the 20-member Congress Working Committee, the majority of whose members are appointed by the party president (handpicked by the prime minister when the party is in power), wields enormous influence. The party is also organized into various committees and sections (e.g., youth and women’s groups), and it publishes a daily newspaper, the National Herald. Mirroring the party’s declining fortunes, the party’s membership dropped from nearly 40 million in the mid-1990s to under 20 million at the beginning of the 21st century.";

        contacts = new ArrayList<>();
         
        contacts.add(new keyValue("facebook","www.facebook.com/IndianNationalCongress"));
        contacts.add(new keyValue("twitter","www.twitter.com/INCIndia"));
        contacts.add(new keyValue("website","www.inc.in"));
        Collections.reverse(contacts);

    }

    private void raga(){

        imageID = R.drawable.raga;

        keyvalues.add(new keyValue("Abbreviation","INC"));
        keyvalues.add(new keyValue("President","Rahul Gandhi"));
        keyvalues.add(new keyValue("Parliamentary Chairperson","Sonia Gandhi"));
        keyvalues.add(new keyValue("Founded","28 December 1885"));
        keyvalues.add(new keyValue("Ideology","Social democracy\n" +
                "Democratic socialism\n" +
                "Social liberalism\n" +
                "Hindu left[6]\n" +
                "Swadeshi movement\n" +
                "Gandhian socialism\n" +
                "Secularism\n" +
                "Progressivism"));
        keyvalues.add(new keyValue("Alliance","United Progressive Alliance (UPA)"));
        keyvalues.add(new keyValue("Seats in Lok Sabha","47 / 545"));
        keyvalues.add(new keyValue("Seats in Rajya Sabha","50 / 245"));
        Collections.reverse(keyvalues);

        descriptionText = "Indian National Congress, byname Congress Party, broadly based political party of India. Formed in 1885, the Indian National Congress dominated the Indian movement for independence from Great Britain. It subsequently formed most of India’s governments from the time of independence and often had a strong presence in many state governments. The Congress Party is a hierarchically structured party. Delegates from state and district parties attend an annual national conference, which elects a president and the All India Congress Committee. However, the 20-member Congress Working Committee, the majority of whose members are appointed by the party president (handpicked by the prime minister when the party is in power), wields enormous influence. The party is also organized into various committees and sections (e.g., youth and women’s groups), and it publishes a daily newspaper, the National Herald. Mirroring the party’s declining fortunes, the party’s membership dropped from nearly 40 million in the mid-1990s to under 20 million at the beginning of the 21st century.";

        contacts = new ArrayList<>();
         
        contacts.add(new keyValue("facebook","www.facebook.com/IndianNationalCongress"));
        contacts.add(new keyValue("twitter","www.twitter.com/INCIndia"));
        contacts.add(new keyValue("website","www.inc.in"));
        Collections.reverse(contacts);

    }

    private void amitshah(){

        imageID = R.drawable.amitshah;

        keyvalues.add(new keyValue("Abbreviation","INC"));
        keyvalues.add(new keyValue("President","Rahul Gandhi"));
        keyvalues.add(new keyValue("Parliamentary Chairperson","Sonia Gandhi"));
        keyvalues.add(new keyValue("Founded","28 December 1885"));
        keyvalues.add(new keyValue("Ideology","Social democracy\n" +
                "Democratic socialism\n" +
                "Social liberalism\n" +
                "Hindu left[6]\n" +
                "Swadeshi movement\n" +
                "Gandhian socialism\n" +
                "Secularism\n" +
                "Progressivism"));
        keyvalues.add(new keyValue("Alliance","United Progressive Alliance (UPA)"));
        keyvalues.add(new keyValue("Seats in Lok Sabha","47 / 545"));
        keyvalues.add(new keyValue("Seats in Rajya Sabha","50 / 245"));
        Collections.reverse(keyvalues);

        descriptionText = "Indian National Congress, byname Congress Party, broadly based political party of India. Formed in 1885, the Indian National Congress dominated the Indian movement for independence from Great Britain. It subsequently formed most of India’s governments from the time of independence and often had a strong presence in many state governments. The Congress Party is a hierarchically structured party. Delegates from state and district parties attend an annual national conference, which elects a president and the All India Congress Committee. However, the 20-member Congress Working Committee, the majority of whose members are appointed by the party president (handpicked by the prime minister when the party is in power), wields enormous influence. The party is also organized into various committees and sections (e.g., youth and women’s groups), and it publishes a daily newspaper, the National Herald. Mirroring the party’s declining fortunes, the party’s membership dropped from nearly 40 million in the mid-1990s to under 20 million at the beginning of the 21st century.";

        contacts = new ArrayList<>();
         
        contacts.add(new keyValue("facebook","www.facebook.com/IndianNationalCongress"));
        contacts.add(new keyValue("twitter","www.twitter.com/INCIndia"));
        contacts.add(new keyValue("website","www.inc.in"));
        Collections.reverse(contacts);

    }

    private void mayavati(){

        imageID = R.drawable.mayawati;

        keyvalues.add(new keyValue("Abbreviation","INC"));
        keyvalues.add(new keyValue("President","Rahul Gandhi"));
        keyvalues.add(new keyValue("Parliamentary Chairperson","Sonia Gandhi"));
        keyvalues.add(new keyValue("Founded","28 December 1885"));
        keyvalues.add(new keyValue("Ideology","Social democracy\n" +
                "Democratic socialism\n" +
                "Social liberalism\n" +
                "Hindu left[6]\n" +
                "Swadeshi movement\n" +
                "Gandhian socialism\n" +
                "Secularism\n" +
                "Progressivism"));
        keyvalues.add(new keyValue("Alliance","United Progressive Alliance (UPA)"));
        keyvalues.add(new keyValue("Seats in Lok Sabha","47 / 545"));
        keyvalues.add(new keyValue("Seats in Rajya Sabha","50 / 245"));
        Collections.reverse(keyvalues);

        descriptionText = "Indian National Congress, byname Congress Party, broadly based political party of India. Formed in 1885, the Indian National Congress dominated the Indian movement for independence from Great Britain. It subsequently formed most of India’s governments from the time of independence and often had a strong presence in many state governments. The Congress Party is a hierarchically structured party. Delegates from state and district parties attend an annual national conference, which elects a president and the All India Congress Committee. However, the 20-member Congress Working Committee, the majority of whose members are appointed by the party president (handpicked by the prime minister when the party is in power), wields enormous influence. The party is also organized into various committees and sections (e.g., youth and women’s groups), and it publishes a daily newspaper, the National Herald. Mirroring the party’s declining fortunes, the party’s membership dropped from nearly 40 million in the mid-1990s to under 20 million at the beginning of the 21st century.";

        contacts = new ArrayList<>();
         
        contacts.add(new keyValue("facebook","www.facebook.com/IndianNationalCongress"));
        contacts.add(new keyValue("twitter","www.twitter.com/INCIndia"));
        contacts.add(new keyValue("website","www.inc.in"));
        Collections.reverse(contacts);

    }

    private void sushma(){

        imageID = R.drawable.sushma;

        keyvalues.add(new keyValue("Abbreviation","INC"));
        keyvalues.add(new keyValue("President","Rahul Gandhi"));
        keyvalues.add(new keyValue("Parliamentary Chairperson","Sonia Gandhi"));
        keyvalues.add(new keyValue("Founded","28 December 1885"));
        keyvalues.add(new keyValue("Ideology","Social democracy\n" +
                "Democratic socialism\n" +
                "Social liberalism\n" +
                "Hindu left[6]\n" +
                "Swadeshi movement\n" +
                "Gandhian socialism\n" +
                "Secularism\n" +
                "Progressivism"));
        keyvalues.add(new keyValue("Alliance","United Progressive Alliance (UPA)"));
        keyvalues.add(new keyValue("Seats in Lok Sabha","47 / 545"));
        keyvalues.add(new keyValue("Seats in Rajya Sabha","50 / 245"));
        Collections.reverse(keyvalues);

        descriptionText = "Indian National Congress, byname Congress Party, broadly based political party of India. Formed in 1885, the Indian National Congress dominated the Indian movement for independence from Great Britain. It subsequently formed most of India’s governments from the time of independence and often had a strong presence in many state governments. The Congress Party is a hierarchically structured party. Delegates from state and district parties attend an annual national conference, which elects a president and the All India Congress Committee. However, the 20-member Congress Working Committee, the majority of whose members are appointed by the party president (handpicked by the prime minister when the party is in power), wields enormous influence. The party is also organized into various committees and sections (e.g., youth and women’s groups), and it publishes a daily newspaper, the National Herald. Mirroring the party’s declining fortunes, the party’s membership dropped from nearly 40 million in the mid-1990s to under 20 million at the beginning of the 21st century.";

        contacts = new ArrayList<>();
         
        contacts.add(new keyValue("facebook","www.facebook.com/IndianNationalCongress"));
        contacts.add(new keyValue("twitter","www.twitter.com/INCIndia"));
        contacts.add(new keyValue("website","www.inc.in"));
        Collections.reverse(contacts);

    }

    private void sonia(){

        imageID = R.drawable.sonia;

        keyvalues.add(new keyValue("Abbreviation","INC"));
        keyvalues.add(new keyValue("President","Rahul Gandhi"));
        keyvalues.add(new keyValue("Parliamentary Chairperson","Sonia Gandhi"));
        keyvalues.add(new keyValue("Founded","28 December 1885"));
        keyvalues.add(new keyValue("Ideology","Social democracy\n" +
                "Democratic socialism\n" +
                "Social liberalism\n" +
                "Hindu left[6]\n" +
                "Swadeshi movement\n" +
                "Gandhian socialism\n" +
                "Secularism\n" +
                "Progressivism"));
        keyvalues.add(new keyValue("Alliance","United Progressive Alliance (UPA)"));
        keyvalues.add(new keyValue("Seats in Lok Sabha","47 / 545"));
        keyvalues.add(new keyValue("Seats in Rajya Sabha","50 / 245"));
        Collections.reverse(keyvalues);

        descriptionText = "Indian National Congress, byname Congress Party, broadly based political party of India. Formed in 1885, the Indian National Congress dominated the Indian movement for independence from Great Britain. It subsequently formed most of India’s governments from the time of independence and often had a strong presence in many state governments. The Congress Party is a hierarchically structured party. Delegates from state and district parties attend an annual national conference, which elects a president and the All India Congress Committee. However, the 20-member Congress Working Committee, the majority of whose members are appointed by the party president (handpicked by the prime minister when the party is in power), wields enormous influence. The party is also organized into various committees and sections (e.g., youth and women’s groups), and it publishes a daily newspaper, the National Herald. Mirroring the party’s declining fortunes, the party’s membership dropped from nearly 40 million in the mid-1990s to under 20 million at the beginning of the 21st century.";

        contacts = new ArrayList<>();
         
        contacts.add(new keyValue("facebook","www.facebook.com/IndianNationalCongress"));
        contacts.add(new keyValue("twitter","www.twitter.com/INCIndia"));
        contacts.add(new keyValue("website","www.inc.in"));
        Collections.reverse(contacts);

    }

    private void smriti(){

        imageID = R.drawable.smriti;

        keyvalues.add(new keyValue("Abbreviation","INC"));
        keyvalues.add(new keyValue("President","Rahul Gandhi"));
        keyvalues.add(new keyValue("Parliamentary Chairperson","Sonia Gandhi"));
        keyvalues.add(new keyValue("Founded","28 December 1885"));
        keyvalues.add(new keyValue("Ideology","Social democracy\n" +
                "Democratic socialism\n" +
                "Social liberalism\n" +
                "Hindu left[6]\n" +
                "Swadeshi movement\n" +
                "Gandhian socialism\n" +
                "Secularism\n" +
                "Progressivism"));
        keyvalues.add(new keyValue("Alliance","United Progressive Alliance (UPA)"));
        keyvalues.add(new keyValue("Seats in Lok Sabha","47 / 545"));
        keyvalues.add(new keyValue("Seats in Rajya Sabha","50 / 245"));
        Collections.reverse(keyvalues);

        descriptionText = "Indian National Congress, byname Congress Party, broadly based political party of India. Formed in 1885, the Indian National Congress dominated the Indian movement for independence from Great Britain. It subsequently formed most of India’s governments from the time of independence and often had a strong presence in many state governments. The Congress Party is a hierarchically structured party. Delegates from state and district parties attend an annual national conference, which elects a president and the All India Congress Committee. However, the 20-member Congress Working Committee, the majority of whose members are appointed by the party president (handpicked by the prime minister when the party is in power), wields enormous influence. The party is also organized into various committees and sections (e.g., youth and women’s groups), and it publishes a daily newspaper, the National Herald. Mirroring the party’s declining fortunes, the party’s membership dropped from nearly 40 million in the mid-1990s to under 20 million at the beginning of the 21st century.";

        contacts = new ArrayList<>();
         
        contacts.add(new keyValue("facebook","www.facebook.com/IndianNationalCongress"));
        contacts.add(new keyValue("twitter","www.twitter.com/INCIndia"));
        contacts.add(new keyValue("website","www.inc.in"));
        Collections.reverse(contacts);

    }

    private void arvind(){

        imageID = R.drawable.arvind;

        keyvalues.add(new keyValue("Abbreviation","INC"));
        keyvalues.add(new keyValue("President","Rahul Gandhi"));
        keyvalues.add(new keyValue("Parliamentary Chairperson","Sonia Gandhi"));
        keyvalues.add(new keyValue("Founded","28 December 1885"));
        keyvalues.add(new keyValue("Ideology","Social democracy\n" +
                "Democratic socialism\n" +
                "Social liberalism\n" +
                "Hindu left[6]\n" +
                "Swadeshi movement\n" +
                "Gandhian socialism\n" +
                "Secularism\n" +
                "Progressivism"));
        keyvalues.add(new keyValue("Alliance","United Progressive Alliance (UPA)"));
        keyvalues.add(new keyValue("Seats in Lok Sabha","47 / 545"));
        keyvalues.add(new keyValue("Seats in Rajya Sabha","50 / 245"));
        Collections.reverse(keyvalues);

        descriptionText = "Indian National Congress, byname Congress Party, broadly based political party of India. Formed in 1885, the Indian National Congress dominated the Indian movement for independence from Great Britain. It subsequently formed most of India’s governments from the time of independence and often had a strong presence in many state governments. The Congress Party is a hierarchically structured party. Delegates from state and district parties attend an annual national conference, which elects a president and the All India Congress Committee. However, the 20-member Congress Working Committee, the majority of whose members are appointed by the party president (handpicked by the prime minister when the party is in power), wields enormous influence. The party is also organized into various committees and sections (e.g., youth and women’s groups), and it publishes a daily newspaper, the National Herald. Mirroring the party’s declining fortunes, the party’s membership dropped from nearly 40 million in the mid-1990s to under 20 million at the beginning of the 21st century.";

        contacts = new ArrayList<>();
         
        contacts.add(new keyValue("facebook","www.facebook.com/IndianNationalCongress"));
        contacts.add(new keyValue("twitter","www.twitter.com/INCIndia"));
        contacts.add(new keyValue("website","www.inc.in"));
        Collections.reverse(contacts);

    }

    private void lkadvani(){

        imageID = R.drawable.lkadavani;

        keyvalues.add(new keyValue("Abbreviation","INC"));
        keyvalues.add(new keyValue("President","Rahul Gandhi"));
        keyvalues.add(new keyValue("Parliamentary Chairperson","Sonia Gandhi"));
        keyvalues.add(new keyValue("Founded","28 December 1885"));
        keyvalues.add(new keyValue("Ideology","Social democracy\n" +
                "Democratic socialism\n" +
                "Social liberalism\n" +
                "Hindu left[6]\n" +
                "Swadeshi movement\n" +
                "Gandhian socialism\n" +
                "Secularism\n" +
                "Progressivism"));
        keyvalues.add(new keyValue("Alliance","United Progressive Alliance (UPA)"));
        keyvalues.add(new keyValue("Seats in Lok Sabha","47 / 545"));
        keyvalues.add(new keyValue("Seats in Rajya Sabha","50 / 245"));
        Collections.reverse(keyvalues);

        descriptionText = "Indian National Congress, byname Congress Party, broadly based political party of India. Formed in 1885, the Indian National Congress dominated the Indian movement for independence from Great Britain. It subsequently formed most of India’s governments from the time of independence and often had a strong presence in many state governments. The Congress Party is a hierarchically structured party. Delegates from state and district parties attend an annual national conference, which elects a president and the All India Congress Committee. However, the 20-member Congress Working Committee, the majority of whose members are appointed by the party president (handpicked by the prime minister when the party is in power), wields enormous influence. The party is also organized into various committees and sections (e.g., youth and women’s groups), and it publishes a daily newspaper, the National Herald. Mirroring the party’s declining fortunes, the party’s membership dropped from nearly 40 million in the mid-1990s to under 20 million at the beginning of the 21st century.";

        contacts = new ArrayList<>();
         
        contacts.add(new keyValue("facebook","www.facebook.com/IndianNationalCongress"));
        contacts.add(new keyValue("twitter","www.twitter.com/INCIndia"));
        contacts.add(new keyValue("website","www.inc.in"));
        Collections.reverse(contacts);

    }


    //TODO : Edit all the functions with appropriate data












}

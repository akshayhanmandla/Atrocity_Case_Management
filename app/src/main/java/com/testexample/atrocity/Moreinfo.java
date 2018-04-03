package com.testexample.atrocity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.SearchView;

import com.testexample.atrocity.R;

import java.util.ArrayList;

public class Moreinfo extends AppCompatActivity
        implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    private SearchManager searchManager;
    private android.widget.SearchView searchView;
    private com.testexample.atrocity.MyExpandableListAdapter listAdapter;
    private ExpandableListView myList;
    private ArrayList<com.testexample.atrocity.ParentRow> parentList = new ArrayList<com.testexample.atrocity.ParentRow>();
    private ArrayList<com.testexample.atrocity.ParentRow> showTheseParentList = new ArrayList<com.testexample.atrocity.ParentRow>();
    private MenuItem searchItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moreinfo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        parentList = new ArrayList<com.testexample.atrocity.ParentRow>();
        showTheseParentList = new ArrayList<com.testexample.atrocity.ParentRow>();

        // The app will crash if display list is not called here.
        displayList();

        // This expands the list.
        expandAll();


    }

    private void loadData() {
        ArrayList<ChildRow> childRows = new ArrayList<ChildRow>();
        ParentRow parentRow = null;

        childRows.add(new ChildRow(R.mipmap.generic_icon
                ,"1. Putting any inedible or obnoxious\n" +
                "substance\n"+"One lakh rupees to the victim. Payment to then\n" +
                "victim be made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "1.कोई अखाद्य या अप्रिय पदार्थ डाल\n"+"पीड़ित को एक लाख रुपए उसके बाद भुगतान करने के लिए भुगतान किया जाना चाहिए:\n" +
                "\n" +
                "(i) 10 प्रतिशत सीरियल नंबर (1), (4) और (5) के लिए एफआईआर चरण में सीरियल नंबर (2) और (3) और 25 प्रतिशत के लिए प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 40 प्रतिशत जब आरोपी को निचली अदालत ने सीरियल नंबर (2) और (3) के लिए दोषी ठहराया है और सीरियल नंबर (1) के लिए इसी तरह 25 प्रतिशत का दोषी ठहराया गया है,\n" +
                "(4) और (5)"));

        parentRow = new ParentRow("Poisoning", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "2. Dumping excreta, sewage, carcasses\n" +
                "or any other obnoxious substance\n"+
                "One lakh rupees to the victim. Payment to then\n" +
                "victim be made as follows:\n" +
                "(i) 10 per cent. at First Information Report (FIR)\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 40 per cent. when the accused are convicted"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "2.मलमूत्र, सीवेज, शव या किसी अन्य अप्रिय पदार्थ को डंपिंग \n" +
                "पीड़ित को एक लाख रुपए उसके बाद भुगतान करने के लिए भुगतान किया जाना चाहिए:\n" +
                "\n" +
                "(i) 10 प्रतिशत सीरियल नंबर (1), (4) और (5) के लिए एफआईआर चरण में सीरियल नंबर (2) और (3) और 25 प्रतिशत के लिए प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 40 प्रतिशत जब आरोपी को निचली अदालत ने सीरियल नंबर (2) और (3) के लिए दोषी ठहराया है और सीरियल नंबर (1) के लिए इसी तरह 25 प्रतिशत का दोषी ठहराया गया है,\n" +
                "(4) और (5)"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "3. Dumping excreta, waste matter,\n" +
                "carcasses with intent to cause injury,\n" +
                "insult or annoyance \n" +
                "One lakh rupees to the victim. Payment to then\n" +
                "victim be made as follows:\n" +
                "(i) 10 per cent. at First Information Report (FIR)\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 40 per cent. when the accused are convicted"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "3.मस्तिष्कडंपिंग, अपशिष्टपदार्थ, चोट, अपमानयाझुंझलाहटकाकारणबननेकेइरादेसेशवों \n" +
                "पीड़ित को एक लाख रुपए उसके बाद भुगतान करने के लिए भुगतान किया जाना चाहिए:\n" +
                "\n" +
                "(i) 10 प्रतिशत सीरियल नंबर (1), (4) और (5) के लिए एफआईआर चरण में सीरियल नंबर (2) और (3) और 25 प्रतिशत के लिए प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 40 प्रतिशत जब आरोपी को निचली अदालत ने सीरियल नंबर (2) और (3) के लिए दोषी ठहराया है और सीरियल नंबर (1) के लिए इसी तरह 25 प्रतिशत का दोषी ठहराया गया है,\n" +
                "(4) और (5)"));
        parentRow = new ParentRow("Dumping", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "4. Garlanding with footwear or parading naked\n" +
                "or semi-naked\n"+
                "One lakh rupees to the victim. Payment to then\n" +
                "victim be made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "4.जूते के साथ गारदान या नग्न या अर्ध-नाक परेड करना \n" +
                "पीड़ित को एक लाख रुपए उसके बाद भुगतान करने के लिए भुगतान किया जाना चाहिए:\n" +
                "\n" +
                "(i) 10 प्रतिशत सीरियल नंबर (1), (4) और (5) के लिए एफआईआर चरण में सीरियल नंबर (2) और (3) और 25 प्रतिशत के लिए प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 40 प्रतिशत जब आरोपी को निचली अदालत ने सीरियल नंबर (2) और (3) के लिए दोषी ठहराया है और सीरियल नंबर (1) के लिए इसी तरह 25 प्रतिशत का दोषी ठहराया गया है,\n" +
                "(4) और (5)"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "5. Forcibly commiting acts such as removing\n" +
                "clothes, forcible tonsuring of head,\n" +
                "removing moustaches, painting face or\n" +
                "body\n"+
                "One lakh rupees to the victim. Payment to then\n" +
                "victim be made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "5.जबरन रूप से ऐसे कृत्यों को कम करना जैसे कि कपड़े निकालना, सिर के जबरन खूनी होना, मूंछें हटाने, पेंटिंग का चेहरा या शरीर \n" +
                "पीड़ित को एक लाख रुपए उसके बाद भुगतान करने के लिए भुगतान किया जाना चाहिए:\n" +
                "\n" +
                "(i) 10 प्रतिशत सीरियल नंबर (1), (4) और (5) के लिए एफआईआर चरण में सीरियल नंबर (2) और (3) और 25 प्रतिशत के लिए प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 40 प्रतिशत जब आरोपी को निचली अदालत ने सीरियल नंबर (2) और (3) के लिए दोषी ठहराया है और सीरियल नंबर (1) के लिए इसी तरह 25 प्रतिशत का दोषी ठहराया गया है,\n" +
                "(4) और (5)"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "18. Intentional insult or intimidation to\n" +
                "humiliate in any place within public view\n"+
                "One lakh rupees to the victim. Payment to be\n" +
                "made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "18.सार्वजनिक विवाह के भीतर किसी भी जगह में अपमानित करने के लिए जानबूझकर अपमान या धमकी \n" +
                "पीड़ित को एक लाख रुपए भुगतान करने के लिए निम्नानुसार है:\n" +
                "\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 25 प्रतिशत जब आरोपियों को निचली अदालत ने दोषी ठहराया है"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "19. Abusing by caste name in any place\n" +
                "within public view\n"+
                "One lakh rupees to the victim. Payment to be\n" +
                "made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "19.सार्वजनिक दृश्यके भीतर किसीभी जगह जातिके नाम से दुर्व्यवहार" +
                "पीड़ित को एक लाख रुपए भुगतान करने के लिए निम्नानुसार है:\n" +
                "\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 25 प्रतिशत जब आरोपियों को निचली अदालत ने दोषी ठहराया है"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "21. Promoting feelings of enmity, hatred or\n" +
                "ill-will\n"+
                "One lakh rupees to the victim. Payment to be\n" +
                "made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "21.दुश्मनी, नफरत या अस्वस्थता की भावनाओं को बढ़ावा देना\n" +
                "पीड़ित को एक लाख रुपए भुगतान करने के लिए निम्नानुसार है:\n" +
                "\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 25 प्रतिशत जब आरोपियों को निचली अदालत ने दोषी ठहराया है"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "22. Disrespecting by words or any other\n" +
                "means of any late person held in high\n" +
                "esteem\n"+
                "One lakh rupees to the victim. Payment to be\n" +
                "made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "22.उच्च सम्मान में आयोजित किसी भी देर के व्यक्ति के शब्दों या किसी अन्य माध्यम से अनायास \n" +
                "पीड़ित को एक लाख रुपए भुगतान करने के लिए निम्नानुसार है:\n" +
                "\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 25 प्रतिशत जब आरोपियों को निचली अदालत ने दोषी ठहराया है"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "37. Causing physical harm or mental agony\n" +
                "on the allegation of being a witch or\n" +
                "practicing witchcraft or being a witch\n"+
                "One lakh rupees to the victim and also\n" +
                "commensurate with the indignity, insult, injury\n" +
                "and defamation suffered by the victim. Payment\n" +
                "to be made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "37.एक चुड़ैल या जादू टोना का अभ्यास\n" +
                " या एक चुड़ैल होने के आरोप पर शारीरिक नुकसान \n" +
                "या मानसिक पीड़ा होने के कारण [अधिनियम 3 (1) \n" +
                "पीड़ित को एक लाख रुपये और भी\n" +
                "अपमान, अपमान, चोट के साथ अनुरूप\n" +
                "और शिकार द्वारा पीड़ित मानहानि। भुगतान\n" +
                "इस प्रकार किया जाना है:\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) पर\n" +
                "मंच;\n" +
                "(ii) 50 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;\n" +
                "(iii) 25 प्रतिशत जब अभियुक्त दोषी हैं\n" +
                "निचली अदालत ने"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "45. Murder or Death.\n"+
                "Eight lakh and twenty-five thousand rupees to\n" +
                "the victim. Payment to be made as follows:\n" +
                "(i) 50 per cent. after post mortem report;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "45.हत्या या मौत\n" +
                "आठ लाख और पच्चीस हजार रुपए\n" +
                "पीड़ित। भुगतान करने के लिए निम्नानुसार है:\n" +
                "(i) 50 प्रतिशत पोस्टमार्टम रिपोर्ट के बाद;\n" +
                "(ii) 50 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय।"));
        parentRow = new ParentRow("Miss Behaviour", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "6. Wrongful occupation or cultivation of land\n"+
                "One lakh rupees to the victim. The land or\n" +
                "premises or water supply or irrigation facility shall\n" +
                "be restored where necessary at Government cost\n" +
                "by the concerned State Government or Union\n" +
                "territory Administration. Payment to the victim\n" +
                "be made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "6.खेती या भूमिका गलत कब्ज़ा \n" +
                "पीड़ित को एक लाख रुपए उसके बाद भुगतान करने के लिए भुगतान किया जाना चाहिए:\n" +
                "\n" +
                "(i) 10 प्रतिशत सीरियल नंबर (1), (4) और (5) के लिए एफआईआर चरण में सीरियल नंबर (2) और (3) और 25 प्रतिशत के लिए प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 40 प्रतिशत जब आरोपी को निचली अदालत ने सीरियल नंबर (2) और (3) के लिए दोषी ठहराया है और सीरियल नंबर (1) के लिए इसी तरह 25 प्रतिशत का दोषी ठहराया गया है,\n" +
                "(4) और (5)\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "पीड़ित को एक लाख रुपए संबंधित राज्य सरकार या संघीय क्षेत्र प्रशासन द्वारा सरकारी लागत पर जहां आवश्यक हो वहां भूमि या परिसर या पानी की आपूर्ति या सिंचाई सुविधा को बहाल किया जाएगा। शिकार के लिए भुगतान निम्नानुसार किया जाना चाहिए:\n" +
                "\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "(iii) 25 प्रतिशत जब आरोपियों को निचली अदालत ने दोषी ठहराया है"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "7. Wrongful dispossession of land or\n" +
                "premises or interfering with the rights,\n" +
                "including forest rights.\n"+
                "One lakh rupees to the victim. The land or\n" +
                "premises or water supply or irrigation facility shall\n" +
                "be restored where necessary at Government cost\n" +
                "by the concerned State Government or Union\n" +
                "territory Administration. Payment to the victim\n" +
                "be made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "7.भूमिया परिसर का अधिकारया अधिकारके साथ हस्तक्षेप, वन अधिकार सहित दस्ती\n" +
                "पीड़ित को एक लाख रुपए उसके बाद भुगतान करने के लिए भुगतान किया जाना चाहिए:\n" +
                "\n" +
                "(i) 10 प्रतिशत सीरियल नंबर (1), (4) और (5) के लिए एफआईआर चरण में सीरियल नंबर (2) और (3) और 25 प्रतिशत के लिए प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 40 प्रतिशत जब आरोपी को निचली अदालत ने सीरियल नंबर (2) और (3) के लिए दोषी ठहराया है और सीरियल नंबर (1) के लिए इसी तरह 25 प्रतिशत का दोषी ठहराया गया है,\n" +
                "(4) और (5)\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "पीड़ित को एक लाख रुपए संबंधित राज्य सरकार या संघीय क्षेत्र प्रशासन द्वारा सरकारी लागत पर जहां आवश्यक हो वहां भूमि या परिसर या पानी की आपूर्ति या सिंचाई सुविधा को बहाल किया जाएगा। शिकार के लिए भुगतान निम्नानुसार किया जाना चाहिए:\n" +
                "\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "(iii) 25 प्रतिशत जब आरोपियों को निचली अदालत ने दोषी ठहराया है"));
        parentRow = new ParentRow("Land Related", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "8. Begar or other forms of forced or\n" +
                "bonded labour\n"+
                "One lakh rupees to the victim. Payment to be\n" +
                "made as follows:\n" +
                "(i) Payment of 25 per cent. First Information\n" +
                "Report (FIR) stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "8.बेगर या मजबूर या बंधुआ लैब के अन्य रूप \n" +
                "पीड़ित को एक लाख रुपए भुगतान करने के लिए निम्नानुसार है:\n" +
                "\n" +
                "(i) 25 प्रतिशत का भुगतान प्रथम सूचना रिपोर्ट (एफआईआर) चरण;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 25 प्रतिशत जब आरोपियों को निचली अदालत ने दोषी ठहराया है"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "9. Compelling to dispose or carry human or\n" +
                "animal carcasses, or to dig graves\n"+
                "One lakh rupees to the victim. Payment to be\n" +
                "made as follows:\n" +
                "(i) Payment of 25 per cent. First Information\n" +
                "Report (FIR) stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "9.मानव या पशु शवों को निपटाने या ले जाने या कब्र खोदने के लिए मजबूर \n" +
                "पीड़ित को एक लाख रुपए भुगतान करने के लिए निम्नानुसार है:\n" +
                "\n" +
                "(i) 25 प्रतिशत का भुगतान प्रथम सूचना रिपोर्ट (एफआईआर) चरण;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 25 प्रतिशत जब आरोपियों को निचली अदालत ने दोषी ठहराया है"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "10. Making a member of the Scheduled\n" +
                "Castes or the Scheduled Tribes to do\n" +
                "manual scavenging or employing him for\n" +
                "such purpose\n"+
                "One lakh rupees to the victim. Payment to be\n" +
                "made as follows:\n" +
                "(i) Payment of 25 per cent. First Information\n" +
                "Report (FIR) stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "10.अनुसूचित जातियों या अनुसूचित जनजातियों के सदस्य को इस तरह के उद्देश्य के लिए मैनुअल स्केन्वेन्गिंग या नियोजित करना\n" +
                "पीड़ित को एक लाख रुपए भुगतान करने के लिए निम्नानुसार है:\n" +
                "\n" +
                "(i) 25 प्रतिशत का भुगतान प्रथम सूचना रिपोर्ट (एफआईआर) चरण;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 25 प्रतिशत जब आरोपियों को निचली अदालत ने दोषी ठहराया है"));
        parentRow = new ParentRow("Labour related", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "11. Performing, or promoting dedication of a\n" +
                "Scheduled Caste or a Scheduled Tribe\n" +
                "woman as a devadasi\n"+
                "One lakh rupees to the victim. Payment to be\n" +
                "made as follows:\n" +
                "(i) Payment of 25 per cent. First Information\n" +
                "Report (FIR) stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "11.अनुसूचित जाति या अनुसूचित जनजाति की महिला को देवदासी के रूप में समर्पण करने या उसे बढ़ावा देना\n" +
                "पीड़ित को एक लाख रुपए भुगतान करने के लिए निम्नानुसार है:\n" +
                "\n" +
                "(i) 25 प्रतिशत का भुगतान प्रथम सूचना रिपोर्ट (एफआईआर) चरण;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 25 प्रतिशत जब आरोपियों को निचली अदालत ने दोषी ठहराया है"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "23. Intentionally touching a Scheduled\n" +
                "Caste or a Scheduled Tribe woman\n" +
                "without consent, using acts or\n" +
                "gestures, as an act of sexual nature\n"+
                "Two lakh rupees to the victim. Payment to be\n" +
                "made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "23.अनुसूचित जाति या अनुसूचित जनजाति की महिला को बिना किसी संवैधानिक कृत्य या इशारों का प्रयोग करने के लिए यौन प्रकृति \n" +
                "पीड़ित को दो लाख रुपये। भुगतान करने के लिए निम्नानुसार है:\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "(iii) 25 प्रतिशत जब अभियुक्त दोषी हैं\n" +
                "निचली अदालत ने"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "24a.Eight lakh and twenty-five thousand rupees to\n" +
                "the victim with burns exceeding and 2 per cent\n"+
                "and above burns on face or in case of functional\n" +
                "impairment of eye, ear, nose and mouth and or\n" +
                "burn injury on body exceeding 30 per cent;\n"+
                "(i) 50 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. after receipt of medical report."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "24a.भारतीय दंड संहिता की धारा 326 बी (1860 का 45) - एसिड को फेंकने के लिए स्वेच्छा से फेंकना या प्रयास करना \n" +
                "आठ लाख और पच्चीस हजार रुपए\n" +
                "पीड़ित से अधिक जल और 2 प्रतिशत\n" + "\n" +
                "और ऊपर चेहरे पर जलता है या आंख, कान, नाक और मुंह के क्रियात्मक हानि के मामले में या 30% से अधिक शरीर पर चोट जलाते हैं;\n" + "\n" +
                "आइटम (ए) से (सी) के मामले में भुगतान निम्नानुसार किया जाना है:\n" +
                "(i) 50 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "(ii) 50 प्रतिशत चिकित्सा रिपोर्ट प्राप्त होने के बाद"));

        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "24b.four lakh and fifteen thousand rupees to the\n" +
                "victim with burns between 10 per cent. to 30 per\n" +
                "cent. on the body;\n"+
                "(i) 50 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. after receipt of medical report."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "\n" +
                "24b.भारतीय दंड संहिता की धारा 326 बी (1860 का 45) - एसिड को फेंकने के लिए स्वेच्छा से फेंकना या प्रयास करना \n"
                +"पीड़ित व्यक्ति के लिए 10 लाख के बीच चार लाख और पंद्रह हजार रुपये। 30 प्रतिशत तक शरीर पर; \n" +
                " \n" +
                "आइटम (ए) से (सी) के मामले में भुगतान निम्नानुसार किया जाना है:\n" +
                "(i) 50 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "(ii) 50 प्रतिशत चिकित्सा रिपोर्ट प्राप्त होने के बाद"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "24c.eighty-five thousand rupees to the victim with\n" +
                "burns less than 10 per cent. on the body other\n" +
                "than on face.\n"+
                "(i) 50 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. after receipt of medical report."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "24c.भारतीय दंड संहिता की धारा 326 बी (1860 का 45) - एसिड को फेंकने के लिए स्वेच्छा से फेंकना या प्रयास करना\n" +
                "24c.10 फीसदी से कम जल वाले पीड़ित व्यक्ति के पास 85 हजार रुपये। चेहरे पर छोड़कर शरीर पर अन्य \n" +
                "आइटम (ए) से (सी) के मामले में भुगतान निम्नानुसार किया जाना है:\n" +
                "(i) 50 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "(ii) 50 प्रतिशत चिकित्सा रिपोर्ट प्राप्त होने के बाद"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "25. Section 354 of the Indian Penal Code (45 of\n" +
                "1860) -- Assault or criminal force to\n" +
                "woman with intent to outrage her\n" +
                "modesty. \n"+
                "Two lakh rupees to the victim. Payment to be\n" +
                "made as follows:\n" +
                "(i) 50 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 25 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. on conclusion of trial by\n" +
                "the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "25.\tभारतीय दंड संहिता (1860 का 45) की धारा 354 – उसकी विनम्रताको अपमानित करने के इरादेसे महिलाको आक्रमण या आपराधिक बल\n"
                +"भारतीय दंड संहिता (1860 का 45) की धारा 354 – उसकी विनम्रताको अपमानित करने के इरादेसे महिलाको आक्रमण या आपराधिक बल \n" +
                "पीड़ित को दो लाख रुपये। भुगतान करने के लिए निम्नानुसार है:\n" +
                "(i) 50 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "(ii) 25 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "(iii) 25 प्रतिशत द्वारा परीक्षण के निष्कर्ष पर\n" +
                "निचली अदालत\n"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "26. Section 354A of the Indian Penal Code (45\n" +
                "of 1860)--Sexual harassment and\n" +
                "punishment for sexual harassment. \n"+
                "Two lakh rupees to the victim. Payment to be\n" +
                "made as follows:\n" +
                "(i) 50 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 25 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. on conclusion of trial by the\n" +
                "lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "26.भारतीय दंड संहिता की धारा 354 ए (1860 का 45) – यौन उत्पीड़न और यौन उत्पीड़न के लिए सजा\n"+"भारतीय दंड संहिता की धारा 354 ए (1860 का 45) – यौन उत्पीड़न और यौन उत्पीड़न के लिए सजा \n" +
                "पीड़ित को दो लाख रुपये। भुगतान होना\n" +
                "निम्नानुसार बनाया गया है:\n" +
                "(i) 50 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) पर\n" +
                "मंच;\n" +
                "(ii) 25 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;\n" +
                "(iii) 25 प्रतिशत द्वारा परीक्षण के निष्कर्ष पर\n" +
                "निचली अदालत।"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "27. Section 354 B of the Indian Penal Code (45\n" +
                "of 1860)-- Assault or use of criminal force\n" +
                "to woman with intent to disrobe\n"+
                "Two lakh rupees to the victim. Payment to be\n" +
                "made as follows:\n" +
                "(i) 50 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 25 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. on conclusion of trial by\n" +
                "the lower court.\n"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "27.भारतीय दंड संहिता की धारा 354 बी " +
                "(1860 का 45) - अपहृत करने के इरादे से महिला " +
                "को आक्रमण या आपराधिक बल का इस्तेमाल करना\n"
                +"पीड़ित को दो लाख रुपये। भुगतान होना\n" +
                "निम्नानुसार बनाया गया है:\n" +
                "(i) 50 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) पर\n" +
                "मंच;\n" +
                "(ii) 25 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;\n" +
                "(iii) 25 प्रतिशत द्वारा परीक्षण के निष्कर्ष पर\n" +
                "निचली अदालत"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "28. Section 354 C of the Indian Penal Code (45\n" +
                "of 1860)-- Voyeurism\n"+
                "Two lakh rupees to the victim. Payment to be\n" +
                "made as follows:\n" +
                "(i) 10 per cent. at First Information Report (FIR)\n" +
                "stage\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court.\n" +
                "(iii) 40 per cent. when the accused are\n" +
                "convicted by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "28.भारतीय दंड संहिता की धारा 354 सी (1860 का 45) - छिपकली [धारा 3 (2) (वीए) अधिनियम की अनुसूची के साथ पढ़ा गया\n" +
                "पीड़ित को दो लाख रुपये। भुगतान होना\n" +
                "निम्नानुसार बनाया गया है:\n" +
                "(i) 10 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) पर\n" +
                "मंच\n" +
                "(ii) 50 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय।\n" +
                "(iii) 40 प्रतिशत जब अभियुक्त हैं\n" +
                "निचली अदालत ने दोषी ठहराया"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "29. Section 354 D of the Indian Penal Code (45\n" +
                "of 1860) -- Stalking.\n"+
                "Two lakh rupees to the victim. Payment to be\n" +
                "made as follows:\n" +
                "(i) 10 per cent. at First Information Report (FIR)\n" +
                "stage\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court.\n" +
                "(iii) 40 per cent. when the accused are\n" +
                "convicted by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "29.भारतीय दंड संहिता की धारा 354 डी (1860 का 45) - पीछा करना [धारा 3 (2) (वीए) अधिनियम की अनुसूची के साथ पढ़ा गया\n" +
                "पीड़ित को दो लाख रुपये। भुगतान होना\n" +
                "निम्नानुसार बनाया गया है:\n" +
                "(i) 10 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) पर\n" +
                "मंच;\n" +
                "(ii) 50 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;\n" +
                "(iii) 40 प्रतिशत जब अभियुक्त हैं\n" +
                "निचली अदालत ने दोषी ठहराया"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "30. Section 376B of the Indian Penal Code (45\n" +
                "of 1860)-- Sexual intercourse by husband\n" +
                "upon his wife during separation\n"+
                "Two lakh rupees to the victim. Payment to be\n" +
                "made as follows:\n" +
                "(i) 50 per cent. after medical examination and\n" +
                "confirmatory medical report;\n" +
                "(ii) 25 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "30.भारतीय दंड संहिता की धारा 376 बी (1860 का 45) \n " +
                "विभक्त होने के दौरान अपनी पत्नी पर पति द्वारा संभोग। \n" +
                " [धारा 3 (2) (वीए) अधिनियम की अनुसूची के साथ पढ़ा गया\n" +
                "पीड़ित को दो लाख रुपये। भुगतान होना\n" +
                "निम्नानुसार बनाया गया है:\n" +
                "(i) 50 प्रतिशत मेडिकल परीक्षा के बाद और\n" +
                "पुष्टि चिकित्सा रिपोर्ट;\n" +
                "(ii) 25 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;\n" +
                "(iii) 25 प्रतिशत जब अभियुक्त दोषी हैं\n" +
                "निचली अदालत ने"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "31. Section 376C of the Indian Penal Code (45\n" +
                "of 1860) -- Sexual intercourse by a person\n" +
                "in authority. \n"+
                "Four lakh rupees to the victim. Payment to be\n" +
                "made as follows:\n" +
                "(i) 50 per cent. after medical examination and\n" +
                "confirmatory medical report;\n" +
                "(ii) 25 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "31.भारतीय दंड संहिता की धारा \n" +
                " 376 सी (1860 का 45) – अधिकार में एक \n" +
                "व्यक्तिद्वारा संभोग। [धारा 3 (2) (वीए) अधिनियम की अनुसूची के साथ पढ़ा गया\n" +
                "शिकार के लिए चार लाख रुपए भुगतान होना\n" +
                "निम्नानुसार बनाया गया है:\n" +
                "(i) 50 प्रतिशत मेडिकल परीक्षा के बाद और\n" +
                "पुष्टि चिकित्सा रिपोर्ट;\n" +
                "(ii) 25 प्रतिशत जब चार्जशीट को भेजा जाता है न्यायालय;\n" +
                "(iii) 25 प्रतिशत द्वारा परीक्षण के निष्कर्ष पर\n" +
                "निचली अदालत।"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "32. Section 509 of the Indian Penal Code (45 of\n" +
                "1860)-- Word, gesture or act intended to\n" +
                "insult the modesty of a woman. \n"+
                "Two lakh rupees to the victim. Payment to be\n" +
                "made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "32.भारतीय दंड संहिता की \n" +
                "धारा 50 9 (1860 का 45) - शब्द, इशारा या \n" +
                "अधिनियम जो एक महिला के विनम्रता का \n" +
                "अपमान करने का इरादा है। [धारा 3 (2) (वीए) एसी की अनुसूची के साथ पढ़ा \n" +
                "पीड़ित को दो लाख रुपये। भुगतान होना\n" +
                "निम्नानुसार बनाया गया है:\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) पर\n" +
                "मंच;\n" +
                "(ii) 50 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;\n" +
                "(iii) 25 प्रतिशत जब अभियुक्त दोषी हैं\n" +
                "निचली अदालत ने"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "44. Rape or Gang rape.\n" +
                "(a) Rape\n"+
                "Five lakh rupees to the victim. Payment to be\n" +
                "made as follows:\n"+
                "(i) 50 per cent. after medical examination and\n" +
                "confirmatory medical report;\n" +
                "(ii) 25 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. on conclusion of trial by the\n" +
                "lower court."+"(b) Gang rape \n"+
                "Eight lakh and twenty-five thousand rupees to\n" +
                "the victim. Payment to be made as follows:\n" +
                "(i) 50 per cent. after medical examination and\n" +
                "confirmatory medical report;\n" +
                "(ii) 25 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. on conclusion of trial by the\n" +
                "lower court."));

        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "44.a. बलात्कार या गिरोह बलात्कार (i) बलात्कार\n" +
                " [भारतीय दंड संहिता की धारा 375 (1860 का 45)]\n" +
                "b.बलात्कार या गिरोह बलात्कार(ii) गिरोह बलात्कार\n" +
                " [भारतीय दंड संहिता की धारा 376 डी (1860 का 45)]\n" +
                "शिकार के लिए पांच लाख रुपए भुगतान होना\n" +
                "निम्नानुसार बनाया गया है:\n" +
                "(i) 50 प्रतिशत मेडिकल परीक्षा के बाद और\n" +
                "पुष्टि चिकित्सा रिपोर्ट;\n" +
                "(ii) 25 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;\n" +
                "(iii) 25 प्रतिशत द्वारा परीक्षण के निष्कर्ष पर\n" +
                "निचली अदालत। \n" +
                "आठ लाख और पच्चीस हजार रुपए\n" +
                "पीड़ित। भुगतान करने के लिए निम्नानुसार है:\n" +
                "(i) 50 प्रतिशत मेडिकल परीक्षा के बाद और\n" +
                "पुष्टि चिकित्सा रिपोर्ट;\n" +
                "(ii) 25 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;\n" +
                "(iii) 25 प्रतिशत द्वारा परीक्षण के निष्कर्ष पर\n" +
                "निचली अदालत।"));
        parentRow = new ParentRow("Women Related", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "12. Prevention from voting, filing nomination\n"+
                "Eighty-five thousand rupees to the victim.\n" +
                "Payment to be made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "12.मतदान से रोकथाम, नामांकन दाखिल करना \n" +
                "अस्सी-पांच हजार शिकार रुपये। भुगतान करने के लिए निम्नानुसार है:\n" +
                "\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 25 प्रतिशत जब आरोपियों को निचली अदालत ने दोषी ठहराया है"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "13. Forcing, intimidating or obstructing a\n" +
                "holder of office of Panchayat or\n" +
                "Municipality from performing duties\n"+
                "Eighty-five thousand rupees to the victim.\n" +
                "Payment to be made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "13.पंचायत या नगर पालिका के कार्यालय के धारक को ड्यूटी करने से डराने या अवरुद्ध करना\n" +
                " अस्सी-पांच हजार शिकार रुपये। भुगतान करने के लिए निम्नानुसार है:\n" +
                "\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 25 प्रतिशत जब आरोपियों को निचली अदालत ने दोषी ठहराया है"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "35. Forcing of causing to leave house,\n" +
                "village, residence desert place of\n" +
                "residence\n"+
                "Restoration of the site or right to stay in house,\n" +
                "village or other place of residence by the\n" +
                "concerned State Government or Union territory\n" +
                "Administration and relief of one lakh rupees to\n" +
                "the victim and reconstruction of the house at\n" +
                "Government cost, if destroyed. Payment to be\n"+
                "made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "35.घर, गांव, आवास के निवास स्थान \n" +
                " को छोड़ने के लिए मजबूर होना\n" +
                " [अधिनियम की धारा 3 (1) (जेड)]\n" +
                "साइट की बहाली या घर में रहने का अधिकार,\n" +
                "गांव या निवास के अन्य जगह द्वारा\n" +
                "संबंधित राज्य सरकार या संघीय क्षेत्र\n" +
                "प्रशासन और एक लाख रुपए की राहत\n" +
                "पीड़ित और घर के पुनर्निर्माण में\n" +
                "सरकार की लागत, अगर नष्ट हो भुगतान होना \n" +
                "निम्नानुसार बनाया गया है:\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) पर\n" +
                "मंच;\n" +
                "(ii) 50 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;\n" +
                "(iii) 25 प्रतिशत जब अभियुक्त दोषी हैं\n" +
                "निचली अदालत ने"));

        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "36a.Restoration of the right using common\n" +
                "property resources of an area, or burial or\n" +
                "cremation ground equally with others or using\n" +
                "any river, stream, spring, well, tank, cistern,\n" +
                "water-tap or other watering place, or any bathing\n" +
                "ghat, any public conveyance, any road, or\n" +
                "passage equally with others, by the concerned\n" +
                "State Government or Union Territory\n" +
                "Administration and relief of one lakh rupees to\n" +
                "the victim. Payment to be made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court.\n" +
                ""));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "36a.अनुसूचित जाति या अनुसूचित जनजाति \n" +
                "के किसी भी तरीके से किसी भी तरह से रोकना या रोकना-\n" +
                "(ए) किसी क्षेत्र के सामान्य संपत्ति संसाधनों का उपयोग \n" +
                "करना, या दफन या श्मशान जमीन का उपयोग दूसरों के \n" +
                "साथ समान रूप से या किसी नदी, धारा, वसंत, अच्छी तरह से,\n" +
                " टैंक, टाउन, पानी के नल या अन्य पानी की जगह, या किसी\n" +
                " स्नान घंट, कोई सार्वजनिक वाहन, किसी भी सड़क\n" +
                " या मार्ग [अधिनियम की धारा 3 (1) (जीए) (ए)]\n \n" +
                "सामान्य का उपयोग करने की सही बहाली\n" +
                "एक संपत्ति के संपत्ति संसाधन, या दफन या\n" +
                "श्मशान जमीन समान रूप से दूसरों के साथ या उपयोग करते हुए\n" +
                "किसी भी नदी, धारा, वसंत, अच्छी तरह से, टैंक, टाउन,\n" +
                "पानी के नल या अन्य पानी की जगह, या किसी भी स्नान\n" +
                "घाट, कोई सार्वजनिक वाहन, कोई सड़क, या\n" +
                "संबंधित लोगों द्वारा समान रूप से दूसरों के साथ\n" +
                "राज्य सरकार या केंद्रशासित प्रदेश\n" +
                "प्रशासन और एक लाख रुपए की राहत\n" +
                "पीड़ित। भुगतान करने के लिए निम्नानुसार है:\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) पर\n" +
                "मंच;\n" +
                "(ii) 50 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;\n" +
                "(iii) 25 प्रतिशत जब अभियुक्त दोषी हैं\n" +
                "निचली अदालत ने "));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "36b.Restoration of the right of mounting or\n" +
                "riding bicycles or motor cycles or wearing\n" +
                "footwear or new clothes in public places or taking\n" +
                "out wedding procession, or mounting a horse or\n" +
                "any other vehicle during wedding processions,\n" +
                "equally with others by the concerned State\n" +
                "Government or Union territory Administration and\n" +
                "relief of one lakh rupees to the victim. Payment\n"+
                "to be made as follows:\n" +
                "(i) Payment of 25 per cent. at First Information\n" +
                "Report (FIR) stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court;"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "36b.अनुसूचित जाति या अनुसूचित जनजाति \n" +
                "के किसी सदस्य के संबंध में किसी भी तरह से रोकना या रोकना-\n" +
                " (बी) साइकिल या मोटर साइकिल चलाना या \n" +
                "सार्वजनिक स्थानों पर जूते या नए कपड़े पहने या शादी\n" +
                " की जुलूस ले जाना, या घोड़े को बढ़ाना या शादी के \n" +
                "जुलूस के दौरान कोई अन्य वाहन\n" +
                " [अधिनियम की धारा 3 (1) (जीए) (बी)]\n" +
                "बढ़ते या यातायात के अधिकार की बहाली\n" +
                "साइकिल या मोटर साइकिल पहने या पहने\n" +
                "सार्वजनिक स्थानों में जूते लेना या नये कपड़े\n" +
                "बाहर शादी की जुलूस, या एक घोड़ा बढ़ते या\n" +
                "शादी के जुलूस के दौरान कोई अन्य वाहन,\n" +
                "संबंधित राज्य द्वारा समान रूप से दूसरों के साथ\n" +
                "सरकार या संघीय क्षेत्र प्रशासन और\n" +
                "पीड़ित को एक लाख रुपए की राहत भुगतान इस प्रकार किया जाना है:\n" +
                "(i) 25 प्रतिशत का भुगतान प्रथम सूचना पर\n" +
                "रिपोर्ट (एफआईआर) चरण;\n" +
                "(ii) 50 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;\n" +
                "(iii) 25 प्रतिशत जब अभियुक्त दोषी हैं\n" +
                "निचली अदालत द्वारा;"));

        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "36c.अनुसूचित जाति या अनुसूचित जनजाति के \n" +
                "किसी सदस्य के संबंध में किसी भी तरह से रोकना या रोकना-\n" +
                "(सी) किसी भी पूजा की जगह में प्रवेश कर रहा है \n" +
                "जो जनता या अन्य व्यक्तियोंके लिए एकही धर्म का प्रकटीकरण कर\n" +
                " रहा है या जत्रा सहित किसीभी धार्मिक, सामाजिक या सांस्कृतिक जुलूस\n" +
                " [भाग 3 (1) (जीए) (सी ) अधिनियमकी)\n\n" +
                "किसी भी प्रवेश करने के अधिकार की बहाली\n" +
                "पूजा के स्थान जो जनता के लिए खुले हैं या\n" +
                "एक ही धर्म का प्रकटीकरण करने वाले अन्य व्यक्ति या\n" +
                "भाग लेने, या किसी भी धार्मिक ले जा रही है\n" +
                "जुलूस या जत्रा, जैसा कि जनता के लिए खुला है या\n" +
                "एक ही धर्म, सामाजिक का प्रतिनिधित्व करने वाले अन्य व्यक्ति\n" +
                "या जत्रा सहित सांस्कृतिक जुलूस, समान रूप से\n" +
                "संबंधित व्यक्ति द्वारा अन्य व्यक्तियों के साथ,\n" +
                "सरकार या संघीय क्षेत्र प्रशासन और\n" +
                "पीड़ित को एक लाख रुपए की राहत भुगतान\n" +
                "इस प्रकार किया जाना है:\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) पर\n" +
                "मंच\n" +
                "(ii) 50 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय।\n" +
                "(iii) 25 प्रतिशत जब अभियुक्त दोषी हैं\n" +
                "निचली अदालत ने"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "36d.Restoration of the right of entering any\n" +
                "educational institution, hospital, dispensary,\n" +
                "primary health centre, shop or place of public\n" +
                "entertainment or any other public place; or using\n" +
                "any utensils or articles meant for public use in\n" +
                "any place open to the public, equally with other\n" +
                "persons by the concerned State Government or\n" +
                "Union territory Administration and relief of one\n" +
                "lakh rupees to the victim. Payment to be made as\n" +
                "follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n"+
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "36d.अनुसूचित जाति या अनुसूचित जनजाति के\n" +
                " किसी सदस्य के संबंध में किसी भी तरह से रोकना या रोकना- \n" +
                "(डी) किसी भी शैक्षणिक संस्थान, अस्पताल, दवाखाने,\n" +
                " प्राथमिक स्वास्थ्य केंद्र, सार्वजनिक मनोरंजन या किसी अन्य\n" +
                " सार्वजनिक स्थान की दुकान या जगह में प्रवेश; या जनता के लिए\n" +
                " किसी भी जगह सार्वजनिक उपयोग के लिए किसी भी बर्तन या\n" +
                " लेख का उपयोग करना [अधिनियम की धारा 3 (1) (जीए) (डी)]\n \n" +
                "किसी भी प्रवेश करने के अधिकार की बहाली\n" +
                "शैक्षिक संस्थान, अस्पताल, औषधालय,\n" +
                "प्राथमिक स्वास्थ्य केंद्र, दुकान या सार्वजनिक स्थान\n" +
                "मनोरंजन या किसी अन्य सार्वजनिक स्थान; या का उपयोग कर\n" +
                "किसी भी बर्तन या सार्वजनिक उपयोग के लिए जरूरी लेख\n" +
                "किसी भी जगह जनता के लिए खुला, समान रूप से अन्य के साथ\n" +
                "संबंधित राज्य सरकार द्वारा या\n" +
                "संघ क्षेत्र प्रशासन और एक की राहत\n" +
                "पीड़ित को लाख रुपये के रूप में भुगतान करने के लिए भुगतान\n" +
                "इस प्रकार है:\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) पर मंच;\n" +
                "(ii) 50 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;\n" +
                "(iii) 25 प्रतिशत जब अभियुक्त दोषी हैं\n" +
                "निचली अदालत ने\n"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "36e.Restoration of the right of practicing any\n" +
                "profession or the carrying on of any occupation,\n" +
                "trade or business or employment in any job\n" +
                "which other members of the public, or any\n" +
                "section thereof, have a right to use or have\n" +
                "access to, by the concerned State\n" +
                "Government/Union territory Administration and\n" +
                "relief of one lakh rupees to the victim. Payment\n" +
                "to be made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "36e.अनुसूचित जाति या अनुसूचित जनजाति के\n" +
                " किसी सदस्य के संबंध में किसी भी तरह से रोकना या रोकना- \n" +
                "(ई) किसी पेशे का अभ्यास करना या किसी व्यवसाय,\n" +
                " व्यवसाय या व्यापार या किसी भी नौकरी में नौकरी पर ले\n" +
                " जाने के लिए जो अन्य लोगों के सदस्यों, या इसके किसी भी \n" +
                "हिस्से में, का उपयोग करने का अधिकार है\n" +
                " [धारा 3 (1) ज़ा) अधिनियम की (ई)\n\n" +
                "किसी भी अभ्यास के अधिकार की बहाली\n" +
                "पेशे या किसी भी व्यवसाय पर ले जाने,\n" +
                "किसी भी नौकरी में व्यापार या व्यवसाय या रोजगार\n" +
                "जो जनता के अन्य सदस्यों, या किसी भी\n" +
                "उसके भाग में, इसका उपयोग करने या प्राप्त करने का अधिकार है\n" +
                "संबंधित राज्य द्वारा अभिगमन\n" +
                "सरकार / संघ राज्य क्षेत्र प्रशासन और\n" +
                "पीड़ित को एक लाख रुपए की राहत भुगतान\n" +
                "इस प्रकार किया जाना है:\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) पर\n" +
                "मंच;\n" +
                "(ii) 50 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;\n" +
                "(iii) 25 प्रतिशत जब अभियुक्त दोषी हैं\n" +
                "निचली अदालत ने"));
        parentRow = new ParentRow("Obstructing from individual rights", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "14. After poll violence and imposition of social\n" +
                "and economic boycott\n"+
                "Eighty-five thousand rupees to the victim.\n" +
                "Payment to be made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "14.सर्वेक्षण हिंसा और सामाजिक और आर्थिक बहिष्कार के लागू होने के बाद\n" +
                "अस्सी-पांच हजार शिकार रुपये। भुगतान करने के लिए निम्नानुसार है:\n" +
                "\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 25 प्रतिशत जब आरोपियों को निचली अदालत ने दोषी ठहराया है"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "15. Committing any offence under this Act\n" +
                "for having voted or not having voted for\n" +
                "a particular candidate\n"+
                "Eighty-five thousand rupees to the victim.\n" +
                "Payment to be made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "15.किसी विशेष उम्मीदवार के लिए मतदान करने या न होने के लिए इस अधिनियम के तहत किसी भी अपराध को कम करना \n" +
                "अस्सी-पांच हजार शिकार रुपये। भुगतान करने के लिए निम्नानुसार है:\n" +
                "\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 25 प्रतिशत जब आरोपियों को निचली अदालत ने दोषी ठहराया है"));
        parentRow = new ParentRow("Vote Related", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "16. Instituting false, malicious or vexatious\n" +
                "legal proceedings\n"+
                "Eighty-five thousand rupees to the victim or\n" +
                "reimbursement of actual legal expenses and\n" +
                "damages, whichever is less. Payment to be\n" +
                "made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n"+
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "16.झूठी, दुर्भावनापूर्ण या परेशान कानूनी कार्यवाही की स्थापना करना\n" +
                "पीड़ित व्यक्ति के लिए पच्चीस हजार रुपए या वास्तविक कानूनी खर्च और क्षतिपूर्ति, जो भी कम हो, की प्रतिपूर्ति। भुगतान करने के लिए निम्नानुसार है:\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) पर\n" +
                "मंच;\n"+"\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "(iii) 25 प्रतिशत जब अभियुक्त दोषी हैं\n" +
                "निचली अदालत ने"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "38. Imposing or threatening a social or\n" +
                "economic boycott\n"+
                "Restoration of provision of all economic and\n" +
                "social services equally with other persons, by the\n" +
                "concerned State Government or Union territory\n" +
                "Administration and relief of one lakh rupees to\n" +
                "the victim. To be paid in full when charge sheet\n" +
                "is sent to the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "38.एक सामाजिक या आर्थिक \n" +
                " बहिष्कार को प्रभावित करना या \n " +
                "धमका देना [अधिनियम की धारा 3 (1) (जेडसी)\n" +
                "सभी आर्थिक और सभी के प्रावधान की बहाली\n" +
                "सामाजिक सेवाओं के समान रूप से अन्य व्यक्तियों के साथ,\n" +
                "संबंधित राज्य सरकार या संघीय क्षेत्र\n" +
                "प्रशासन और एक लाख रुपए की राहत\n" +
                "पीड़ित। चार्जशीट में पूरा भुगतान किया जाना चाहिए\n" +
                "निचली अदालत में भेजा जाता है"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "39. Giving or fabricating false evidence\n"+
                "Four lakh fifteen thousand rupees to the victim.\n" +
                "Payment to be made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "39.झूठे सबूत देते या गढ़ने का \n" +
                "[धारा 3 (2) (i) और (ii) अधिनियम के]\n" +
                "पीड़ित को चार लाख पंद्रह हजार रुपए\n" +
                "भुगतान करने के लिए निम्नानुसार है:\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) पर\n" +
                "मंच;\n" +
                "(ii) 50 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;\n" +
                "(iii) 25 प्रतिशत जब अभियुक्त दोषी हैं\n" +
                "निचली अदालत ने"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "40. Committing offences under the Indian\n" +
                "Penal Code (45 of 1860) punishable with\n" +
                "imprisonment for a term of ten years or\n" +
                "more \n"+
                "Four lakh rupees to the victim and or his\n" +
                "dependents. The amount would vary, if\n" +
                "specifically otherwise provided in this Schedule.\n" +
                "Payment to be made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "40.भारतीय दंड संहिता (1860 का 45) दस \n" +
                "सालया उससे अधिक की अवधिके लिए\n" +
                " कारावासके साथ दंडनीय अपराध\n" +
                " [अधिनियम की धारा 3 (2)]\n" +
                "पीड़ित को चार लाख रुपए या उसके पास\n" +
                "आश्रितों। राशि अलग-अलग होगी, अगर\n" +
                "विशेष रूप से अन्यथा इस अनुसूची में उपलब्ध कराई गई\n" +
                "भुगतान करने के लिए निम्नानुसार है:\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) पर\n" +
                "मंच;\n" +
                "(ii) 50 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;\n" +
                "(iii) 25 प्रतिशत जब अभियुक्त दोषी हैं\n" +
                "निचली अदालत ने "));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "41. Committing offences under the Indian\n" +
                "Penal Code (45 of 1860) specified in the\n" +
                "Schedule to the Act punishable with such\n" +
                "punishment as specified under the Indian\n" +
                "Penal Code for such offences\n"+
                "Two lakh rupees to the victim and or his\n" +
                "dependents. The amount would vary if\n" +
                "specifically otherwise provided in this Schedule.\n" +
                "Payment to be made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court;"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "41.भारतीय दंड संहिता (1860 का 45) के अंतर्गत\n" +
                " अपराधों को दंडित करने के लिए भारतीय दंड संहिताके तह\n" +
                " तइसतरह की सजाके लिए दंडनीय अधिनियम के अनुच्छेद में निर्दिष्ट \n" +
                "[धारा 3 (2) (वीए) अधिनियम की अनुसूची के साथ पढ़ा]" +
                "पीड़ित को दो लाख रुपये और उसके पास\n" +
                "आश्रितों। राशि भिन्न होती है अगर\n" +
                "विशेष रूप से अन्यथा इस अनुसूची में उपलब्ध कराई गई\n" +
                "भुगतान करने के लिए निम्नानुसार है:\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) पर\n" +
                "मंच;\n" +
                "(ii) 50 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;\n" +
                "(iii) 25 प्रतिशत जब अभियुक्त दोषी हैं\n" +
                "निचली अदालत द्वारा;"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "42. Victimisation at the hands of a public\n" +
                "servant\n"+
                "Two lakh rupees to the victim and or his\n" +
                "dependents. Payment to be made as follows:\n"+
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "42.एक सार्वजनिक नौकर के हाथ में शिकार\n" +
                " [अधिनियम की धारा 3 (2) (vii)] \n" +
                "पीड़ित को दो लाख रुपये और उसके पास\n" +
                "आश्रितों। भुगतान करने के लिए निम्नानुसार है: \n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) पर\n" +
                "मंच;\n" +
                "(ii) 50 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;\n" +
                "(iii) 25 प्रतिशत जब अभियुक्त दोषी हैं\n" +
                "निचली अदालत ने"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "46. Additional relief to victims of murder,\n" +
                "death, massacre, rape, gang rape,\n" +
                "permanent incapacitation and dacoity. \n"+
                "In addition to relief amounts paid under above\n" +
                "items, relief may be arranged within three\n" +
                "months of date of atrocity as follows:-\n" +
                "(i) Basic Pension to the widow or other\n" +
                "dependents of deceased persons belonging to a\n" +
                "Scheduled Caste or a Scheduled Tribe amounting\n" +
                "to five thousand rupees per month, as applicable\n" +
                "to a Government servant of the concerned State\n" +
                "Government or Union territory Administration,\n" +
                "with admissible dearness allowance and\n" +
                "employment to one member of the family of the\n" +
                "deceased, and provision of agricultural land, an\n" +
                "house, if necessary by outright purchase;\n" +
                "(ii) Full cost of the education up to graduation\n" +
                "level and maintenance of the children of the\n" +
                "victims. Children may be admitted to Ashram\n"+
                "schools or residential schools, fully funded by the\n" +
                "Government;\n" +
                "(iii) Provision of utensils, rice, wheat, dals,\n" +
                "pulses, etc., for a period of three months."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "46.हत्या, मृत्यु, नरसंहार, बलात्कार, सामूहिक\n" +
                " बलात्कार, स्थायी अक्षमता और डकैती के शिकार\n" +
                " लोगोंको अतिरिक्त राहत।\n" +
                "ऊपर दी गई राशि के अलावा राहत राशि के अलावा\n" +
                "वस्तुओं, राहत तीन के भीतर व्यवस्थित किया जा सकता है\n" +
                "अत्याचार की तारीखों के महीने निम्नानुसार हैं: -\n" +
                "(i) विधवा या अन्य के लिए मूल पेंशन\n" +
                "एक से संबंधित मृत व्यक्तियों के आश्रितों\n" +
                "अनुसूचित जाति या अनुसूचित जनजाति की राशि\n" +
                "प्रति माह पांच हजार रुपए, जैसा लागू हो\n" +
                "संबंधित राज्य के सरकारी कर्मचारी को\n" +
                "सरकार या संघ राज्य क्षेत्र प्रशासन,\n" +
                "स्वीकार्य महंगाई भत्ता के साथ और\n" +
                "के परिवार के एक सदस्य को रोजगार\n" +
                "मृतक, और कृषि भूमि की व्यवस्था, एक\n" +
                "घर, यदि एकमुश्त खरीद द्वारा आवश्यक हो;\n" +
                "(ii) स्नातक स्तर की पढ़ाई तक की शिक्षा की पूरी लागत\n" +
                "के बच्चों के स्तर और रखरखाव\n" +
                "पीड़ितों। बच्चों को आश्रम में भर्ती कराया जा सकता है\n" +
                "स्कूलों या आवासीय स्कूलों, पूरी तरह से वित्त पोषित\n" +
                "सरकार;\n" +
                "(iii) बर्तन, चावल, गेहूं, दाल,\n" +
                "दालें, आदि, तीन महीने की अवधि के लिए।"));
        parentRow = new ParentRow("Law Related", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "17. Giving false and frivolous information to a\n" +
                "public servant\n"+
                "One lakh rupees to the victim or reimbursement\n" +
                "of actual legal expenses and damages, whichever\n" +
                "is less. Payment to be made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "17.सार्वजनिक सर्विस में झूठी और व्यर्थ जानकारी दे रही है\n" +
                "पीड़ित को एक लाख रुपए या वास्तविक कानूनी खर्च और क्षतिपूर्ति, जो भी कम हो, की प्रतिपूर्ति भुगतान करने के लिए निम्नानुसार है:\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "(iii) 25 प्रतिशत जब अभियुक्त दोषी हैं\n" +
                "निचली अदालत ने"));
        parentRow = new ParentRow("Fake Information", childRows);
        parentList.add(parentRow);


        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "20. Destroying, damaging or defiling any\n" +
                "object held sacred or in high esteem\n"+
                "One lakh rupees to the victim. Payment to be\n" +
                "made as follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "20.पवित्र या उच्च सम्मान में आयोजित किसी भी वस्तु को नष्ट करना, हानिकारक या अशुद्ध करना\n" +
                "पीड़ित को एक लाख रुपए भुगतान करने के लिए निम्नानुसार है:\n" +
                "\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) चरण में;\n" +
                "\n" +
                "(ii) 50 प्रतिशत जब आरोप पत्र अदालत में भेजी जाती है;\n" +
                "\n" +
                "(iii) 25 प्रतिशत जब आरोपियों को निचली अदालत ने दोषी ठहराया है"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "47. Complete destruction or burnt houses.\n"+
                "Brick or stone masonary house to be constructed\n" +
                "or provided at Government cost where it has\n" +
                "been burnt or destroyed.”"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "47.पूरा विनाश या जला घरों" +
                "ईंट या पत्थर की मज़ेदार घर का निर्माण\n" +
                "या सरकारी लागत पर उपलब्ध कराई गई है जहां यह है\n" +
                "जला दिया गया या नष्ट हो गया। \"\n"));
        parentRow = new ParentRow("Damage Related", childRows);
        parentList.add(parentRow);


        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "33. Fouling or corrupting of water\n"+
                "Full cost of restoration of normal facility,\n" +
                "including cleaning when the water is fouled, to be\n" +
                "borne by the concerned State Government or\n" +
                "Union territory Administration. In addition, an\n" +
                "amount of eight lakh twenty-five thousand rupees\n" +
                "shall be deposited with the District Magistrate for\n" +
                "creating community assets of the nature to be\n" +
                "decided by the District Authority in consultation\n" +
                "with the Local Body."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "33.पानी का दूषित या भ्रष्ट [अधिनियम के धारा 3 (1) (एक्स)] \n" +
                "सामान्य सुविधा की बहाली की पूरी लागत,\n" +
                "जब पानी खराब हो जाता है, सफाई के साथ-साथ\n" +
                "संबंधित राज्य सरकार द्वारा उठाए गए या\n" +
                "संघ क्षेत्र प्रशासन इसके अलावा, एक\n" +
                "आठ लाख पच्चीस हजार रुपए की राशि\n" +
                "इसके लिए जिला मजिस्ट्रेट के साथ जमा किया जाएगा\n" +
                "प्रकृति की सामुदायिक संपत्ति बनाने के लिए\n" +
                "परामर्श से जिला प्राधिकरण द्वारा निर्णय लिया गया\n" +
                "स्थानीय निकाय के साथ"));
        parentRow = new ParentRow("Water Related", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "34.  Denial of customary right of passage to\n" +
                "a place of public resort or obstruction\n" +
                "from using or accessing public resort\n"+
                "Four lakh twenty-five thousand rupees to the\n" +
                "victim and cost of restoration of right of passage\n" +
                "by the concerned State Government or Union\n" +
                "territory Administration. Payment to be made as\n" +
                "follows:\n" +
                "(i) 25 per cent. at First Information Report (FIR)\n" +
                "stage;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;\n" +
                "(iii) 25 per cent. when the accused are convicted\n" +
                "by the lower court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "34.सार्वजनिक रिजॉर्ट या सार्वजनिक सहारा\n " +
                "का उपयोग करने या पहुंचने से रोकने के \n" +
                " लिए प्रथागत अधिकार का उल्लंघन \n" +
                "[अधिनियम के धारा 3 (1) (वाई)]\n" +
                "चार लाख पच्चीस हजार रुपए\n" +
                "पीड़ित और बीतने के अधिकार की बहाली की लागत\n" +
                "संबंधित राज्य सरकार या संघ द्वारा\n" +
                "क्षेत्र प्रशासन के रूप में भुगतान करने के लिए भुगतान\n" +
                "इस प्रकार है:\n" +
                "(i) 25 प्रतिशत प्रथम सूचना रिपोर्ट (एफआईआर) पर\n" +
                "मंच;\n" +
                "(ii) 50 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;\n" +
                "(iii) 25 प्रतिशत जब अभियुक्त दोषी हैं\n" +
                "निचली अदालत ने"));
        parentRow = new ParentRow("Denial of customary rights", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "43a. Disability. Guidelines for evaluation of\n" +
                "various disabilities and procedure for\n" +
                "certification as contained in the Ministry\n" +
                "of Social Justice and Empowerment\n" +
                "Notification No. 16-18/97-NI, dated the\n" +
                "1st June, 2001. A copy of the notification\n" +
                "is at Annexure-II.\n" +
                "(a) 100 per cent. incapacitation \n"+
                "Eight lakh and twenty-five thousand rupees to\n" +
                "the victim. Payment to be made as follows:\n" +
                "(i) 50 per cent. after medical examination and\n" +
                "confirmatory medical report;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "43a.विकलांगता ।सामाजिक न्याय और सशक्तीकरण अधि\n" +
                " सूचनासं। 16-18 / 97-एनआई, 1 जून, 2001 के \n" +
                "दिनांक में प्रमाणित के लिए विभिन्न विकलांगों और\n" +
                " प्रक्रिया ओं के मूल्यांकन के लिए दिशा निर्देश । अधि सूचना\n" +
                " की एक प्रतिअनुबंध- II में है।\n" +
                "(ए) 100 प्रतिशत अशक्तता\n" +
                "आठ लाख और पच्चीस हजार रुपए\n" +
                "पीड़ित। भुगतान करने के लिए निम्नानुसार है:\n" +
                "(i) 50 प्रतिशत मेडिकल परीक्षा के बाद और\n" +
                "पुष्टि चिकित्सा रिपोर्ट;\n" +
                "(ii) 50 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "43b. Disability. Guidelines for evaluation of\n" +
                "various disabilities and procedure for\n" +
                "certification as contained in the Ministry\n" +
                "of Social Justice and Empowerment\n" +
                "Notification No. 16-18/97-NI, dated the\n" +
                "1st June, 2001. A copy of the notification\n" +
                "is at Annexure-II.\n" +
                "(b) where incapacitation is less than 100\n" +
                "per cent. but more than 50 per cent.\n"+
                "Four lakh and fifty thousand rupees to the victim.\n" +
                "Payment to be made as follows:\n" +
                "(i) 50 per cent. after medical examination and\n" +
                "confirmatory medical report;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court;"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "43b.विकलांगता ।सामाजिक न्याय और सशक्तीकरण\n" +
                " अधि सूचनासं। 16-18 / 97-एनआई, 1 जून, 2001 के \n" +
                "दिनांक में प्रमाणित के लिए विभिन्न विकलांगों और प्रक्रिया ओं के मूल्यांकन \n" +
                "के लिए दिशा निर्देश । अधि सूचना की एक प्रतिअनुबंध- II मे है।\n" +
                "बी) जहां अक्षमता 100% से कम है लेकिन 50 प्रतिशत से अधिक" +
                "पीड़ित को चार लाख और पचास हजार रुपए\n" +
                "भुगतान करने के लिए निम्नानुसार है:\n" +
                "(i) 50 प्रतिशत मेडिकल परीक्षा के बाद और\n" +
                "पुष्टि चिकित्सा रिपोर्ट;\n" +
                "(ii) 50 प्रतिशत जब चार्जशीट को भेजा जाता है\n" +
                "न्यायालय;\n" +
                "पीड़ित को दो लाख और पचास हजार रुपए"));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "43c. Disability. Guidelines for evaluation of\n" +
                "various disabilities and procedure for\n" +
                "certification as contained in the Ministry\n" +
                "of Social Justice and Empowerment\n" +
                "Notification No. 16-18/97-NI, dated the\n" +
                "1st June, 2001. A copy of the notification\n" +
                "is at Annexure-II.\n" +
                "(c) where incapacitation is less than 50\n" +
                "per cent. \n"+
                "Two lakh and fifty thousand rupees to the victim.\n" +
                "Payment to be made as follows:\n" +
                "(i) 50 per cent. after medical examination and\n" +
                "confirmatory medical report;\n" +
                "(ii) 50 per cent. when the charge sheet is sent to\n" +
                "the court."));
        childRows.add(new ChildRow(R.mipmap.generic_icon
                , "43c.विकलांगता ।सामाजिक न्याय \n" +
                "और सशक्तीकरण अधि सूचनासं। 16-18 / 97-एनआई, \n" +
                "1 जून, 2001 के दिनांक में प्रमाणित के लिए विभिन्न विकलांगों \n" +
                "और प्रक्रिया ओं के मूल्यांकन के लिए दिशा निर्देश । अधि \n" +
                "सूचना की एक प्रतिअनुबंध- II में है। \n" +
                "(सी) जहां अक्षमता 50% से कम है\n" +
                "पीड़ित को दो लाख और पचास हजार रुपए\n" +
                "भुगतान करने के लिए निम्नानुसार है:\n" +
                "(i) 50 प्रतिशत मेडिकल परीक्षा के बाद और\n" +
                "पुष्टि चिकित्सा रिपोर्ट;\n" +
                "(ii) 50 प्रतिशत जब चार्जशीट को भेजा जाता है ्यायालय।\n"));
        parentRow = new ParentRow("Disability", childRows);
        parentList.add(parentRow);


    }

    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            myList.expandGroup(i);
        } //end for (int i = 0; i < count; i++)
    }

    private void displayList() {
        loadData();

        myList = (ExpandableListView) findViewById(R.id.expandableListView_search);
        listAdapter = new MyExpandableListAdapter(Moreinfo.this, parentList);

        myList.setAdapter(listAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setSearchableInfo
                (searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);
        searchView.requestFocus();

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onClose() {
        listAdapter.filterData("");
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        listAdapter.filterData(query);
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        listAdapter.filterData(newText);
        expandAll();
        return false;
    }
}

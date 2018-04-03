package com.testexample.atrocity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class PoliceStationList extends AppCompatActivity
        implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    private SearchManager searchManager;
    private android.widget.SearchView searchView;
    private com.testexample.atrocity.MyExpandableListAdapter1 listAdapter;
    private ExpandableListView myList;
    private ArrayList<ParentRow> parentList = new ArrayList<ParentRow>();
    private ArrayList<ParentRow> showTheseParentList = new ArrayList<ParentRow>();
    private MenuItem searchItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policestationlist);
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

        parentList = new ArrayList<ParentRow>();
        showTheseParentList = new ArrayList<ParentRow>();

        // The app will crash if display list is not called here.
        displayList();

        // This expands the list.
        expandAll();


    }

    private void loadData() {
        ArrayList<ChildRow> childRows = new ArrayList<ChildRow>();
        ParentRow parentRow = null;

        childRows.add(new ChildRow(R.mipmap.generic_icon ,"AKOLE"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"ASHVI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BELWANDI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BHINGAR CAMP"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"GHARGAON"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"JAMKHED"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KARJAT"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KOPERGAON CITY"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KOPERGAON TALUKA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KOTWALI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"LONI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MIDC"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"NAGAR TALUKA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"NEWASA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"PARNER"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"PATHARDI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"RAHATA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"RAHURI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"RAJUR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SANGAMNER CITY"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SANGAMNER TALUKA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SHEVGAON"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SHINGNAPUR POLICE STATION"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SHIRDI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SHRIGONDA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SHRIRAMPUR CITY"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SHRIRAMPUR TALUKA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SONAI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SUPA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"TOPKHANA"));
        parentRow = new ParentRow("Ahmednagar", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
//        ParentRow parentRow = null;
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"AKOT CITY"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"AKOT RURAL"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"AKOTFILE"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BALAPUR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BARSHITAKLI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BORGAON MANJU"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"CHANNI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"CITY KOTWALI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"CIVIL LINES"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"DABKIROAD"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"DAHIHANDA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"HIWARKHED"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KHADAN"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MIDC"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MUNA	"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MURTIZAPUR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MURTIZAPUR RURAL"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"OLD CITY"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"PATUR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"PINJAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"RAMDASPETH"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"TELHARA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"URAL"));
        parentRow = new ParentRow("Akola", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BADNERA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BHATKULI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"CITY KOTWALI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"FREZARPURA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"GADGE NAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KHOLAPURI GATE"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"NAGPURI GATE"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"NANDGAON PETH"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"RAJAPETH"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"WALGAON"));
        parentRow = new ParentRow("Amravati City", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"ACHALPUR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"ANJANGAON"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"ASEGAON"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BENODA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BRAHMANWADA THADI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"CHADUR BAZAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"CHANDUR RLY"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"DARYAPUR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"DATTAPUR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"DHARNI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KHALLAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KHOLAPUR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KURHA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"LONI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MAHULI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MANGRUL CHAWALA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MANGRUL D"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MORSHI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"NANGAON KH."));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"PARTWADA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"PATHROT"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"RAHIMAPUR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SARMASPURA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SHE.GHAT"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SHIRJAGAON"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SHIRKHED"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"TALEGAON"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"TIWSA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"WARUD"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"YEODA"));
        parentRow = new ParentRow("Amravati Rural", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BEGUMPURA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"CANTONMENT"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"CIDCO"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"CITY CHOWK"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"DAULATABAD"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"HARSUL"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"JAWAHAR NAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"JINSI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KRANTI CHOWK"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MIDC CIDCO"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MIDC WALUJ"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MUKUNDWADI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"OSMANPURA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"PUNDLIK NAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SATARA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"VEDANT NAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"WALUJ"));
        parentRow = new ParentRow("Aurangabad", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"AZAD NAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"CHALISGAON ROAD"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"DEOPUR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"DEOPUR WEST"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"DHULE CITY"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"DHULE TALUKA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"DOINDAICHA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MOHADI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"NARDANA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"NIJAMPUR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"PIMPALNER"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SAKRI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SHINDKHEDA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SHIRPUR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SHIRPUR TALUKA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SONGIR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"THALNER"));
        parentRow = new ParentRow("Dhule", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"AHMEDPUR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"AURAD SHAJANI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"AUSA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BHADA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"CHAKUR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"DEVNI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"GANDHI CHOWK"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"GATEGAON"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"JALKOT"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KASAR SHIRSHI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KILLARI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KINGAON"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"LATUR RURAL"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MIDC"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MURUD"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"NILANGA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"RENAPUR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SHIRUR ANANTAPL"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SHIVAJI NAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"UDGIR CITY"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"UDGIR RURAL"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"VADHONA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"VIVEKANAND CHOWK"));
        parentRow = new ParentRow("Latur", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"AIRPORT"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Aarey Sub"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Agripada"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Amboli"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Andheri"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Antop Hill"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Azad Maidan"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"B.K.C."));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Bandra"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Bangur Nagar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Bhandup"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Bhoiwada"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Borivali"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Byculla"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"CUFFE PARADE"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Charkop"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Chembur"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Chunabhatti"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Colaba"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"D N NAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"DR.D.B MARG"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Dadar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Dahisar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Deonar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Dharavi"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Dindoshi"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Dongri"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Gamdevi"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Ghatkopar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Gorai"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Goregaon"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Govandi"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Irla"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Jogeshwari"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Juhu"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KALA CHOWKY"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Kandivali"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Kanjurmarg"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Kasturba Marg"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Khar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Kherwadi"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Kurar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Kurla"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"L.T. Marg"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"M.H.B COLONY"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"M.R.A. Marg"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MIDC"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Mahim"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Malad"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Malbar Hill"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Malvani"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Mankhurd"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Marine Drive"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Matunga"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Meghwadi"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Mulund"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Mumbai Marine"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Mumbai Marine2"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"N M JOSHI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Nagpada"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Navghar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Nehru Nagar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Nirmal Nagar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Oshiwara"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Pant Nagar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Park Site"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Powai"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Pydhonie"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"R A K MARG"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"R.C.F"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SAKI NAKA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SAMTANAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SIR J.J. MARG"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Sahar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Santacruz"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Sewree"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Shahu Nagar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Shivaji Nagar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Shivaji Park"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Sion"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Tardeo"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Tilak Nagar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Trombay"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"V.P. Road"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"VIKHROLI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"VINOBA BHAVE NAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Vakola"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Vanrai"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Versova"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Vile Parle"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"WADALA TRUCK TERMINAL"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Wadala"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Wadala"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Yellowgate"));
        parentRow = new ParentRow("Mumbai", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"ALANKAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Bharti Vidyapeeth"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Bhosari"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Bhosari MIDC"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Bibbewadi"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Bundgarden"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Chandan Nagar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Chaturshrungi"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Chinchwad"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Dattawadi"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Deccan"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Dighi"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Faraskhana"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Hadapsar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Hinjawadi"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Khadak"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Khadaki"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Khadakwasla"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Kondhwa"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Koregaon Park"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Kothrud"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Lashkar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Marketyard"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Mundhwa"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Nigdi"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Pimipri"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Sahakarnagar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Samarth"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Sangavi"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Shivajinagar"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Sinhgad Road"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Swargate"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Vimantal"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Vishrambaugh"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Vishrantwadi"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Wakad"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Wanawadi"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Warje"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Yerawada"));
        parentRow = new ParentRow("Pune City", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"AMBERNATH"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BADLAPUR EAST"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BADLAPUR WEST"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BAZARPETH"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BHIWANDI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BHOIWADA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"CENTRAL"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"Chitalsar manpada"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"DAIGHAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"DOMBIWALI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"HILL LINE"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KALWA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KAPURBAWDI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KASARWADAVALI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KHADAKPADA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KOLSEWADI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KONGAON"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KOPRI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MANPADA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MFC"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MUMBRA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"NARPOLI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"NAUPADA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"NIZAMPURA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"RABODI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SHANTINAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SHIVAJI NAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SHRINAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"THANE NAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"TILAKNAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"ULHASNAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"VARTAK NAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"VISHNUNAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"VITTHALWADI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"WAGLE ESTATE"));
        parentRow = new ParentRow("Thane City", childRows);
        parentList.add(parentRow);
        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"ADGAON"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"AMBAD"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BHADRAKALI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"DEVLALI CAMP"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"GANGAPUR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"INDIRA NAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MHASRUL"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MUMBAI NAKA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"NASHIK ROAD"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"PANCHVATI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SARKARWADA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SATPUR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"UPNAGAR"));
        parentRow = new ParentRow("Nashik City", childRows);
        parentList.add(parentRow);

        childRows = new ArrayList<ChildRow>();
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"AMALNER"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"AMBAJOGAI CITY"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"AMBAJOGAI RURAL"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"AMBHORA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"ASHTI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BARDAPUR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BEED CITY"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"BEED RURAL"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"CHAKLAMBA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"DHARUR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"DINDRUD"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"GEORAI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"KAIJ"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MAJALGAON CITY"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"MAJALGAON RURAL"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"NEKNOOR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"PARLI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"PARLI CITY"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"PARLI RURAL"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"PATODA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"PIMPALNER"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SAMBHAJINAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SHIRUR KASAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SHIVAJINAGAR"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"SIRSALA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"TALWADA"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"WADWANI"));
        childRows.add(new ChildRow(R.mipmap.generic_icon ,"YOUSUF WADGAON"));
        parentRow = new ParentRow("Beed", childRows);
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
        listAdapter = new com.testexample.atrocity.MyExpandableListAdapter1(PoliceStationList.this, parentList);

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

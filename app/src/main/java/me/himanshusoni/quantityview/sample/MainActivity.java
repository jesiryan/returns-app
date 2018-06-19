package me.himanshusoni.quantityview.sample;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.concurrent.CopyOnWriteArrayList;

import me.himanshusoni.quantityview.QuantityView;

public class MainActivity extends AppCompatActivity implements QuantityView.OnQuantityChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(false);
        }

        CopyOnWriteArrayList<ProductQtyObj> quantities = getProductQtyObjList();
        for (ProductQtyObj qv: quantities) {
            qv.getQuantityView().setOnQuantityChangeListener(this);
        }

        ClearAllActivity clearAllActivity = new ClearAllActivity();
        Button clearAllButton = (Button) findViewById(R.id.clearAllButton);
        clearAllButton.setOnClickListener(clearAllActivity);

        CalculateActivity calculateActivity = new CalculateActivity();
        Button calculateButton = (Button) findViewById(R.id.buttonCalculate);
        calculateButton.setOnClickListener(calculateActivity);

    }

    public CopyOnWriteArrayList<ProductQtyObj> getProductQtyObjList() {
        String valuepan = getResources().getString(R.string.value), yellowlg = getResources().getString(R.string.yellowlg),
                yellowsm = getResources().getString(R.string.yellowsm), brownlg = getResources().getString(R.string.brownlg),
                brownsm = getResources().getString(R.string.brownsm), malt = getResources().getString(R.string.malt),
                brack = getResources().getString(R.string.brack), pura = getResources().getString(R.string.puravitamin),
                multi = getResources().getString(R.string.multiseed), wheatensoda = getResources().getString(R.string.wheatensoda),
                buttermilk = getResources().getString(R.string.buttermilk), toaster = getResources().getString(R.string.toaster),
                crusty = getResources().getString(R.string.crusty), crumb1lb = getResources().getString(R.string.crumbs1lb),
                crumb5lb = getResources().getString(R.string.crumbs5lb), smallplain = getResources().getString(R.string.smallplain),
                harvest = getResources().getString(R.string.harvest);
        float valuepanPrice = Float.parseFloat(getResources().getString(R.string.valuePrice)), yellowlgPrice = Float.parseFloat(getResources().getString(R.string.yellowlgPrice)),
                yellowsmPrice = Float.parseFloat(getResources().getString(R.string.yellowsmPrice)), brownlgPrice = Float.parseFloat(getResources().getString(R.string.brownlgPrice)),
                brownsmPrice = Float.parseFloat(getResources().getString(R.string.brownsmPrice)), maltPrice = Float.parseFloat(getResources().getString(R.string.maltPrice)),
                brackPrice = Float.parseFloat(getResources().getString(R.string.brackPrice)), puraPrice = Float.parseFloat(getResources().getString(R.string.puravitaminPrice)),
                multiPrice = Float.parseFloat(getResources().getString(R.string.multiseedPrice)), wheatensodaPrice = Float.parseFloat(getResources().getString(R.string.wheatensodaPrice)),
                buttermilkPrice = Float.parseFloat(getResources().getString(R.string.buttermilkPrice)), toasterPrice = Float.parseFloat(getResources().getString(R.string.toasterPrice)),
                crustyPrice = Float.parseFloat(getResources().getString(R.string.crustyPrice)), crumb1lbPrice = Float.parseFloat(getResources().getString(R.string.crumbs1lbPrice)),
                crumb5lbPrice = Float.parseFloat(getResources().getString(R.string.crumbs5lbPrice)), smallplainPrice = Float.parseFloat(getResources().getString(R.string.smallplainPrice)),
                harvestPrice = Float.parseFloat(getResources().getString(R.string.harvestPrice));

        CopyOnWriteArrayList<ProductQtyObj> productQtyObjs = new CopyOnWriteArrayList();
        productQtyObjs.add(new ProductQtyObj(crusty, (QuantityView) findViewById(R.id.quantityView_custom_crusty), crustyPrice));
        productQtyObjs.add(new ProductQtyObj(smallplain, (QuantityView) findViewById(R.id.quantityView_custom_smallplain), smallplainPrice));
        productQtyObjs.add(new ProductQtyObj(wheatensoda, (QuantityView) findViewById(R.id.quantityView_custom_wheatensoda), wheatensodaPrice));
        productQtyObjs.add(new ProductQtyObj(buttermilk, (QuantityView) findViewById(R.id.quantityView_custom_buttermilk), buttermilkPrice));
        productQtyObjs.add(new ProductQtyObj(brack, (QuantityView) findViewById(R.id.quantityView_custom_brack), brackPrice));
        productQtyObjs.add(new ProductQtyObj(brownlg, (QuantityView) findViewById(R.id.quantityView_custom_brownlg), brownlgPrice));
        productQtyObjs.add(new ProductQtyObj(yellowlg, (QuantityView) findViewById(R.id.quantityView_custom_yellowlg), yellowlgPrice));
        productQtyObjs.add(new ProductQtyObj(toaster, (QuantityView) findViewById(R.id.quantityView_custom_toaster), toasterPrice));
        productQtyObjs.add(new ProductQtyObj(yellowsm, (QuantityView) findViewById(R.id.quantityView_custom_yellowsm), yellowsmPrice));
        productQtyObjs.add(new ProductQtyObj(brownsm, (QuantityView) findViewById(R.id.quantityView_custom_brownsm), brownsmPrice));
        productQtyObjs.add(new ProductQtyObj(crumb1lb, (QuantityView) findViewById(R.id.quantityView_custom_crumbs1lb), crumb1lbPrice));
        productQtyObjs.add(new ProductQtyObj(crumb5lb, (QuantityView) findViewById(R.id.quantityView_custom_crumbs5lb), crumb5lbPrice));
        productQtyObjs.add(new ProductQtyObj(harvest, (QuantityView) findViewById(R.id.quantityView_custom_harvest), harvestPrice));
        productQtyObjs.add(new ProductQtyObj(pura, (QuantityView) findViewById(R.id.quantityView_custom_puravitamin), puraPrice));
        productQtyObjs.add(new ProductQtyObj(multi, (QuantityView) findViewById(R.id.quantityView_custom_multiseed), multiPrice));
        productQtyObjs.add(new ProductQtyObj(malt, (QuantityView) findViewById(R.id.quantityView_custom_malt), maltPrice));
        productQtyObjs.add(new ProductQtyObj(valuepan,(QuantityView) findViewById(R.id.quantityView_custom_value), valuepanPrice));

        return productQtyObjs;
    }

    public class CalculateActivity extends Activity implements View.OnClickListener {
        public void onClick(View v) {
            alertOneButton();
        }
    }

    public class ClearAllActivity extends Activity implements View.OnClickListener {
        public void onClick(View v) {
            clearAll();
        }
    }

    public void clearAll() {
//        CopyOnWriteArrayList<QuantityView> quantities = getQuantityViews();
        CopyOnWriteArrayList<ProductQtyObj> quantities = getProductQtyObjList();
        for (ProductQtyObj q: quantities) {
            onQuantityChanged(q.getQuantityView(),q.getProductName(), q.getQuantityView().getQuantity(),0,false);
            q.getQuantityView().setQuantity(0);
        }
    }

//    public CopyOnWriteArrayList<QuantityView> getQuantityViews() {
//        return quantities;
//    }

    public String getAllProductsAndPrices(){
        CopyOnWriteArrayList<ProductQtyObj> productQtyObjs = getProductQtyObjList();
        StringBuilder items = new StringBuilder();
        for (ProductQtyObj pqo : productQtyObjs) {
            if(pqo.getProductQty()>0){
                items.append(pqo.getProductQty()+"    \t"+pqo.getProductName()+"   \t "+pqo.getTotal()+"\n");
            }
        }
        return items.toString();
    }

    public double calculate(){
        double total = 0;
        CopyOnWriteArrayList<ProductQtyObj> productQtyObjs = getProductQtyObjList();

        for (ProductQtyObj pqo:productQtyObjs) {
            total = total + pqo.getTotal();
        }

        return toTwoPlaces(Float.parseFloat(""+total));
    }

    public static double toTwoPlaces(float number){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        return Double.parseDouble(df.format(number));
    }

    @Override
    public  void onQuantityChanged(QuantityView quantityView, String extraMessage, int oldQuantity, int newQuantity, boolean programmatically) {
        Toast.makeText(MainActivity.this, "Product: "+extraMessage+" \nOld Quantity: " +oldQuantity+" \nNew Quantity: "+newQuantity, Toast.LENGTH_LONG).show();
        quantityView.setQuantity(newQuantity);
//        Toast.makeText(MainActivity.this, "Quantity: " + newQuantity, Toast.LENGTH_LONG).show();
    }
//    @Override
//    public void onQuantityChanged(int oldQuantity, int newQuantity, boolean programmatically) {
//        QuantityView quantityViewCustom1 = (QuantityView) findViewById(R.id.quantityView_custom_value);
//        if (newQuantity == 3) {
//            quantityViewCustom1.setQuantity(oldQuantity);
//        }
//        Toast.makeText(MainActivity.this, "Quantity: " + newQuantity, Toast.LENGTH_LONG).show();
//    }

    public void alertOneButton() {
        new AlertDialog.Builder(this)
                .setTitle("Total Value")
                .setMessage(getAllProductsAndPrices()+"\n"+"Total: "+calculate())
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    @Override
    public void onLimitReached() {
        Log.d(getClass().getSimpleName(), "Limit reached");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        } else if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

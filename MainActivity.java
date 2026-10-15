package site.hscommunities.chatroom;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebResourceRequest;
import android.webkit.CookieManager;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
public class MainActivity extends Activity {
 WebView web; ValueCallback<Uri[]> fileCallback; final int FILE_REQUEST=12;
 @Override public void onCreate(Bundle b){super.onCreate(b); web=new WebView(this);setContentView(web);web.getSettings().setJavaScriptEnabled(true);web.getSettings().setDomStorageEnabled(true);web.getSettings().setAllowFileAccess(false);CookieManager.getInstance().setAcceptCookie(true);web.setWebViewClient(new WebViewClient(){@Override public boolean shouldOverrideUrlLoading(WebView v,WebResourceRequest r){String u=r.getUrl().toString();if(u.startsWith("https://www.hscommunities.site.je/")||u.startsWith("https://hscommunities.site.je/"))return false;try{startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(u)));}catch(Exception ignored){}return true;}});web.setWebChromeClient(new WebChromeClient(){@Override public boolean onShowFileChooser(WebView v,ValueCallback<Uri[]> cb,FileChooserParams p){fileCallback=cb;try{startActivityForResult(p.createIntent(),FILE_REQUEST);return true;}catch(Exception e){fileCallback=null;return false;}}});web.loadUrl("https://www.hscommunities.site.je/?tab=groups");}
 @Override protected void onActivityResult(int req,int result,Intent data){super.onActivityResult(req,result,data);if(req==FILE_REQUEST&&fileCallback!=null){fileCallback.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(result,data));fileCallback=null;}}
 @Override public void onBackPressed(){if(web.canGoBack())web.goBack();else super.onBackPressed();}
}

# fontbinding
An example of custom fonts in XML using [data binding](http://developer.android.com/tools/data-binding/guide.html).

```xml
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:font="@{`alegreya`}"
    />
```
<img src="https://raw.githubusercontent.com/lisawray/fontbinding/master/screenshot_land.png" alt="Drawing" height="400px"/>


This example includes a simple font cache that automatically loads names from your `assets/fonts` folder and lazy-loads typefaces.  Just drag and drop font files and use them in XML by their normal or lowercase filenames (e.g. "Roboto-Italic" or "roboto-italic" for `Roboto-Italic.otf`). That's it!

Make sure to use the data binding framework to inflate your layout.
```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
}
```

More about data binding: http://developer.android.com/tools/data-binding/guide.html


##Note: 
It's not currently possible to define custom attributes in styles using data binding. 

package com.mikesu.expandablecalendar.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.mikesu.expandablecalendar.ExpandableCalendar;
import com.mikesu.expandablecalendar.view.page.MonthPageView;
import java.util.Random;
import org.joda.time.DateTime;
import org.joda.time.Months;

/**
 * Created by MikeSu on 04/08/16.
 * www.michalsulek.pl
 */

public class MonthViewPagerAdapter extends PagerAdapter {

  public static final int ROWS = 6;
  public static final int COLUMNS = 7;

  public static int cellWidth = 0;
  public static int cellHeight = 0;
  public static boolean cellMeasured = false;

  private Context context;

  public MonthViewPagerAdapter(Context context) {
    this.context = context;
  }

  @Override
  public int getCount() {
    return Months.monthsBetween(ExpandableCalendar.START_DATE, ExpandableCalendar.END_DATE).getMonths();
  }

  @Override
  public boolean isViewFromObject(View view, Object object) {
    return view == object;
  }

  @Override
  public Object instantiateItem(ViewGroup container, int position) {
    MonthPageView monthPageView = new MonthPageView(context);
    container.addView(monthPageView, 0);

    // tmp colors
    monthPageView.setBackgroundColor(Color.rgb(new Random().nextInt(200) + 50, new Random().nextInt(200) + 50, new Random().nextInt(200) + 50));
    // tmp colors
    monthPageView.setup(new DateTime().withDayOfMonth(1).plusMonths(-ExpandableCalendar.monthsBetweenStartAndInit).plusMonths(position));

    return monthPageView;
  }

  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((MonthPageView) object);
  }
}

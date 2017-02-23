package edu.tacoma.uw.plsanch.webserviceslab.course;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by never on 2/9/2017.
 */

public class Course implements Serializable {

    private String mcourseId;
    private String mshortDescription;
    private String mlongDescription;
    private String mprereqs;

    public static final String ID = "id";
    public static final String SHORT_DESC = "shortDesc";

    public Course(String mprereqs, String mcourseId, String mshortDescription, String mlongDescription) {
        this.mprereqs = mprereqs;
        this.mcourseId = mcourseId;
        this.mshortDescription = mshortDescription;
        this.mlongDescription = mlongDescription;
    }


    /**
     * Parses the json string, returns an error message if unsuccessful.
     * Returns course list if success.
     * @param courseJSON
     * @return reason or null if successful.
     */
    public static String parseCourseJSON(String courseJSON, List<Course> courseList) {
        String reason = null;
        if (courseJSON != null) {
            try {
                JSONArray arr = new JSONArray(courseJSON);

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    Course course = new Course(obj.getString(Course.ID), obj.getString(Course.SHORT_DESC)
                            , obj.getString(Course.LONG_DESC), obj.getString(Course.PRE_REQS));
                    courseList.add(course);
                }
            } catch (JSONException e) {
                reason =  "Unable to parse data, Reason: " + e.getMessage();
            }

        }
        return reason;
    }


    public String getMcourseId() {

        return mcourseId;
    }

    public void setMcourseId(String mcourseId) {
        this.mcourseId = mcourseId;
    }

    public String getMshortDescription() {
        return mshortDescription;
    }

    public void setMshortDescription(String mshortDescription) {
        this.mshortDescription = mshortDescription;
    }

    public String getMlongDescription() {
        return mlongDescription;
    }

    public void setMlongDescription(String mlongDescription) {
        this.mlongDescription = mlongDescription;
    }

    public String getMprereqs() {
        return mprereqs;
    }

    public void setMprereqs(String mprereqs) {
        this.mprereqs = mprereqs;
    }

    public static String getID() {
        return ID;
    }

    public static String getShortDesc() {
        return SHORT_DESC;
    }

    public static String getLongDesc() {
        return LONG_DESC;
    }

    public static String getPreReqs() {
        return PRE_REQS;
    }

    public static final String LONG_DESC = "longDesc";
    public static final String PRE_REQS = "prereqs";

}

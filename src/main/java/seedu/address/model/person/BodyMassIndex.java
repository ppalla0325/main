package seedu.address.model.person;

/**
 * Represents a Person's Body Mass Index (BMI) (in kg/m^2) in the Personal Trainer Pro app.
 * Guarantees: mutable; is valid long as Height as declared in {@link #isValidHeight(String)} and Weight as
 * declared in {@Link #isValidWeight(String)} is valid.
 */
public class BodyMassIndex {

    public static final String ACCEPTABLE_CLASSIFICATION = "ACCEPTABLE";
    public static final String OBESE_CLASSIFICATION = "OBESE";
    public static final String OVERWEIGHT_CLASSIFICATION = "OVERWEIGHT";
    public static final String UNDERWEIGHT_CLASSIFICATION = "UNDERWEIGHT";

    public final String value;
    public final String classification;

    private String bodyMassIndex;
    private double bodyMassIndexValue;
    private double heightValue;
    private double weightValue;


    /**
     * Constructs a {@code BodyMassIndex}.
     *
     * @param height A valid height (in cm).
     * @param weight A valid weight (in kg).
     */
    public BodyMassIndex(String height, String weight) {
        bodyMassIndex = getBodyMassIndexString(height, weight);
        this.classification = getBodyMassIndexClassification(height, weight);
        this.value = formatBodyMassIndexStringForDisplay(bodyMassIndex);
    }


    /*
     * Formats the String representation of the BMI value of a Person to four characters (2 decimal places)
     */
    private String formatBodyMassIndexStringForDisplay(String value) {
        return String.format("%.4s", value);

    }


    /*
     * Returns the String representation of the BMI value of a Person when given valid Height and Weight
     */
    private String getBodyMassIndexString(String height, String weight) {
        return Double.toString(getBodyMassIndexValue(height, weight));

    }


    /*
     * Returns the BMI Classification of a Person when given valid Height and Weight
     */

    private String getBodyMassIndexClassification(String height, String weight) {
        bodyMassIndexValue = getBodyMassIndexValue(height, weight);
        if (bodyMassIndexValue < 18.5) {
            return UNDERWEIGHT_CLASSIFICATION;
        } else if (bodyMassIndexValue < 25) {
            return ACCEPTABLE_CLASSIFICATION;
        } else if (bodyMassIndexValue < 30) {
            return OVERWEIGHT_CLASSIFICATION;
        } else {
            return OBESE_CLASSIFICATION;
        }
    }


    /*
     * Returns the BMI value of a Person when given valid Height and Weight
     */
    private double getBodyMassIndexValue(String height, String weight) {
        heightValue = Double.parseDouble(height);
        weightValue = Double.parseDouble(weight);
        bodyMassIndexValue = calculateBodyMassIndexValue(heightValue, weightValue);
        return bodyMassIndexValue;

    }


    /*
     * Returns the BMI value calculated from heightValue and weightValue
     */
    private double calculateBodyMassIndexValue(double heightValue, double weightValue) {
        return weightValue / ((heightValue / 100) * (heightValue / 100));
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}


public class HugeInteger {
    private int[] digits = new int[40]; 
    
    public HugeInteger() {
        for (int i = 0; i < digits.length; i++) {
            digits[i] = 0;
        }
    }
    
    public void parse(String str) {
        if (str.length() > 40) {
            throw new IllegalArgumentException("Number is too large.");
        }
        
        for (int i = 0; i < str.length(); i++) {
            digits[39 - i] = str.charAt(str.length() - 1 - i) - '0';
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 0) {
                leadingZero = false;
            }
            if (!leadingZero) {
                sb.append(digits[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public HugeInteger add(HugeInteger other) {
        HugeInteger result = new HugeInteger();
        int carry = 0;
        
        for (int i = 39; i >= 0; i--) {
            int sum = this.digits[i] + other.digits[i] + carry;
            result.digits[i] = sum % 10;
            carry = sum / 10;
        }
        return result;
    }

    public HugeInteger subtract(HugeInteger other) {
        HugeInteger result = new HugeInteger();
        int borrow = 0;
        
        for (int i = 39; i >= 0; i--) {
            int diff = this.digits[i] - other.digits[i] - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.digits[i] = diff;
        }
        return result;
    }

    public boolean isEqualTo(HugeInteger other) {
        for (int i = 0; i < digits.length; i++) {
            if (this.digits[i] != other.digits[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isNotEqualTo(HugeInteger other) {
        return !this.isEqualTo(other);
    }

    public boolean isGreaterThan(HugeInteger other) {
        for (int i = 0; i < digits.length; i++) {
            if (this.digits[i] > other.digits[i]) {
                return true;
            } else if (this.digits[i] < other.digits[i]) {
                return false;
            }
        }
        return false; 
    }

    public boolean isLessThan(HugeInteger other) {
        return !this.isGreaterThan(other) && !this.isEqualTo(other);
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger other) {
        return this.isGreaterThan(other) || this.isEqualTo(other);
    }

    public boolean isLessThanOrEqualTo(HugeInteger other) {
        return this.isLessThan(other) || this.isEqualTo(other);
    }

    public boolean isZero() {
        for (int i = 0; i < digits.length; i++) {
            if (this.digits[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public HugeInteger multiply(HugeInteger other) {
        HugeInteger result = new HugeInteger();
        
        for (int i = 39; i >= 0; i--) {
            int carry = 0;
            for (int j = 39; j >= 0; j--) {
                int product = this.digits[i] * other.digits[j] + result.digits[i + j + 1] + carry;
                result.digits[i + j + 1] = product % 10;
                carry = product / 10;
            }
        }
        return result;
    }
    
    public HugeInteger divide(HugeInteger other) {
        HugeInteger result = new HugeInteger();
        return result;
    }

    public HugeInteger remainder(HugeInteger other) {
        HugeInteger result = new HugeInteger();
        return result;
    }
}



from sklearn.externals import joblib
import sys
model = joblib.load('python/classifier/model_emailLines_class_uncleaned.pkl')
emailLine = str(sys.argv[1])
#print(emailLine)
print(model.predict([emailLine])[0])
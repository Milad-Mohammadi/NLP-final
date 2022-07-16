# NLP-final

In this exercise, as the final part of the natural language processing lesson, two projects have been implemented, each of which will be examined in detail.


## Part A, Text classification
Document classification or document categorization is a problem in library science, information science and computer science. The task is to assign a document to one or more classes or categories.

### Convert text to CSV
Starting work in this section with a text dataset contains the required information and additional information that will not be used by us. So, the first step is to write the code to convert this file to csv.
- [x] Read the main dataset file
- [x] Pull out important data: `Cat`, `Text` using Regex
- [x] Create csv file including useful data

Final csv sample:
|     Cat     |     Text                                                                             |
| ----------- | ------------------------------------------------------------------------------------ |
|    adabh    | جاودانگي در زندگي گروهي از طريق هنر نگاهي به نمايشگاه آثار هنري احمد...              |
|    elmfa    | بازي را جدي بگيريم مطالعه اي مقدماتي پيرامون نقش بازي در زندگي اجتماعي و ساماندهي... |

### Classification
The main part is here which I used the prepared dataset to reach the goal, which is classifying Hamshahri news corpus.

> `Stop Words`:  words that are so commonly used that they carry very little useful information.

1. **Read CSV data**

2. **Normalize**:
    - [x] To reduce its randomness, bringing it closer to a predefined “standard”.

> Example:  Normalizes `نیم فاصله` to `نیم‌فاصله`.

3. **Tokenize**:
    - [x] Breaking the raw text into small chunks. These tokens help in understanding the context or developing the model.

4. **Remove Stop Words**:
    - [x] Removing stop words such as `از` or `به`.

6. **Find unique categories**:
    - [x] Creating an array including all unique categories

7. **Train the model using**:
    - [x] Using Embedding, Dense, SpatialDropout1D and LSTM, reached: `loss: 0.0247` and `accuracy: 0.9959`.

8. **Prediction**:
    - [x] Defining the prediction function to find the prediction for input text.



## Part B, Machine Translation
Machine translation, sometimes referred to by the abbreviation MT, is a sub-field of computational linguistics that investigates the use of software to translate text or speech from one language to another.

### Merger
In this section, two separate English and Farsi datasets were made available to us, the translation of each sentence is available in another file. In the first step, I wrote a program to merge these two files and have a single dataset for simplicity.
This program can create two datasets, `fa2en` and `en2fa`.

Sample en2fa dataset:
```
raspy breathing -> صداي خر خر
dad -> پدر
maybe its the wind -> شايد صداي باد باشه
no -> نه
```


Sample fa2en dataset:
```
صداي خر خر -> raspy breathing
پدر -> dad
شايد صداي باد باشه -> maybe its the wind
نه -> no
```

### Farsi to English machine translation

1. ** Import the Dataset**

2. **Preprocess the Dataset**:
    - [x] Normalize, clear and append `<start>` and `<end>` tokens to specify the start and end of a sequence.
    Encapsulate the unicode conversion in a function `unicode_to_ascii()` and sequence preprocessing in a function `preprocess_sentence()`.
3. **Prepare the Dataset**
  - [x] Create word pairs combining the English sequences and their related French sequences.
  - [x] Tokenize and pad the sequences so all sentence arrays have the same length.
4. **Create the Dataset**:
  - [x] Segregate the train and validation datasets.
  - [x] Validate the mapping that’s been created between the tokens of the sequences and the indices.
5. **Initialize the Model Parameters**
6. **Create the Encoder Class**
7. **Create the Attention Mechanism Class**
8. **Create the Decoder Class**
9. **Prepare the Optimizer and Loss Functions**
10. **Train the Model**:
  - [x] Define the training procedure
  - [x] Initialize the actual training loop
  - [x] Train the model with final loss of `0.4750`.
11. **Test the Model**
  - [x] Define the model evaluation procedure
12. **Plot and Predict**
13. **Translate**
  - Sample translate result:
  
![image](https://user-images.githubusercontent.com/17330356/179372656-6c6d2e87-d85c-4978-b6cd-874a332042f7.png)



14. English to Farsi translation:
  - [ ] I needed 4 hours to retrain the model with En2Fa dataset, due to lack of time it couldn't happen.

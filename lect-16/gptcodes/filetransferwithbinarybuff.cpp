
/*
 Imagine your company switches the analytics engine to a new interface that takes binary protobuf format instead of CSV.
But you have 100s of existing CSVDataProvider based adapters.
💭 Question:
Design a way to support the new ProtobufAnalyticsEngine without rewriting all 100 adapters.
What design pattern(s) can help here?
*/

#include<iostream>
#include<bits/stdc++.h>

using namespace std;
class CSVDataProvider {
public:
    virtual string getCSVData() = 0;
    virtual ~CSVDataProvider() = default;
};

class JSONApi {
public:
    string getJson() {
        return R"({"name": "Tushar", "age": 24})";
    }
};

class XMLLogger {
public:
    string getXML() {
        return "<user><name>Tushar</name><age>24</age></user>";
    }
};

class ExcelFile {
public:
    string getXLSX() {
        return "EXCEL:BINARY:DATA"; // Just a placeholder
    }
};



class JsonAdapter : public CSVDataProvider {
    JSONApi* jsonApi;
public:
    JsonAdapter(JSONApi* api) : jsonApi(api) {}
    
    string getCSVData() override {
        // Simulate conversion from JSON to CSV
        string json = jsonApi->getJson();
        // Fake conversion
        return "name,age\nTushar,24";
    }
};

class XmlAdapter : public CSVDataProvider {
    XMLLogger* xmlLogger;
public:
    XmlAdapter(XMLLogger* logger) : xmlLogger(logger) {}

    string getCSVData() override {
        // Simulate conversion from XML to CSV
        string xml = xmlLogger->getXML();
        // Fake conversion
        return "name,age\nTushar,24";
    }
};

class ExcelAdapter : public CSVDataProvider {
    ExcelFile* excelFile;
public:
    ExcelAdapter(ExcelFile* file) : excelFile(file) {}

    string getCSVData() override {
        // Simulate conversion from Excel to CSV
        return "name,age\nTushar,24";
    }
};



class AnalyticsEngine {
public:
    void process(CSVDataProvider* provider) {
        string csv = provider->getCSVData();
        cout << "Processing CSV:\n" << csv << endl;
    }
};



// ye binary data dega analytics method ko 
class BinaryProtobufProvider {
public:
    virtual vector<uint8_t> getBinaryProtobuf() = 0;
    virtual ~BinaryProtobufProvider() = default;
};
// humara naya analytics method 
class ProtobufAnalyticsEngine {
public:
    void process(BinaryProtobufProvider* provider) {
        vector<uint8_t> data = provider->getBinaryProtobuf();
        cout << "Processing Binary Protobuf Data: ";
        for (uint8_t byte : data) cout << int(byte) << " ";
        cout << endl;
    }
};
// ye humare old csv ke data to binary buff ke liye compatibe banayega 

class CSVtoProtobufAdapter : public BinaryProtobufProvider {
    CSVDataProvider* csvProvider;
public:
    CSVtoProtobufAdapter(CSVDataProvider* provider) : csvProvider(provider) {}

    vector<uint8_t> getBinaryProtobuf() override {
        string csv = csvProvider->getCSVData();

        // Simulate conversion of CSV to binary protobuf
        vector<uint8_t> binary;
        for (char c : csv)
            binary.push_back(static_cast<uint8_t>(c)); // Dummy encoding

        return binary;
    }
};





int main() {
    AnalyticsEngine engine;

    JSONApi json;
    XmlAdapter xmlAdapter(new XMLLogger());
    ExcelAdapter excelAdapter(new ExcelFile());

    JsonAdapter jsonAdapter(&json);

    engine.process(&jsonAdapter);
    engine.process(&xmlAdapter);
    engine.process(&excelAdapter);

    cout<<"-----------------------------------------"<<endl;

    CSVtoProtobufAdapter protobufAdapter(&jsonAdapter);
    ProtobufAnalyticsEngine protoEngine;
    protoEngine.process(&protobufAdapter);

    return 0;
}

/*
🔥 Follow-Up HARD Question
You now support:

CSV (old system)

Binary Protobuf (new system)

Your company wants a hybrid engine that can process both CSV and Protobuf.

💭 Design this hybrid analytics engine:

It should accept either interface.

Automatically detect adapter type and process accordingly.

Add support for a new format (e.g., XML directly) without changing the hybrid engine.

⛳ Challenge:

Write clean, extensible C++ code.

Apply SOLID principles.

Don't check types with dynamic_cast or typeid in main().

Let me know when you're ready, and I’ll help you think and code it like a real low-level systems designer.
*/

